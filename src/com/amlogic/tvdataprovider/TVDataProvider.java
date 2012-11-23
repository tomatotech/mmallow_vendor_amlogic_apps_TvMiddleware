package com.amlogic.tvdataprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.content.UriMatcher;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.File;
import com.amlogic.tvutil.TVChannelParams;

public class TVDataProvider extends ContentProvider
{
    private static final String TAG = "TVDataProvider";
    private static final String DB_NAME = "dvb.db";
    private static final String AUTHORITY = "com.amlogic.tv.tvdataprovider";
    private static final String DB_VERSION_FIELD = "DATABASE_VERSION";
    private static final int RD_SQL = 1;
    private static final int WR_SQL = 2;
    private static final UriMatcher URI_MATCHER;

    public static final Uri RD_URL = Uri.parse("content://com.amlogic.tv.tvdataprovider/rd_db");
    public static final Uri WR_URL = Uri.parse("content://com.amlogic.tv.tvdataprovider/wr_db");

    private static TVDatabase db = null;
    private static int openCount = 0;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(TVDataProvider.AUTHORITY, "rd_db", RD_SQL);
        URI_MATCHER.addURI(TVDataProvider.AUTHORITY, "wr_db", WR_SQL);
    }

    private static class TVRegion
    {
        private String name;
        private int source;
        private String freqList;

        public TVRegion(String rn, int src, String fl) {
            name = rn;
            source = src;
            freqList = fl;
        }
    };

    private static final TVRegion tvRegions[] = {
        /* default DVB-C */
        new TVRegion("Default DVB-C", TVChannelParams.MODE_QAM,
        "52500000 60250000 68500000 80000000 88000000 115000000 123000000 131000000 139000000 147000000 155000000 163000000 "+
        "171000000 179000000 187000000 195000000 203000000 211000000 219000000 227000000 235000000 243000000 251000000 259000000 "+
        "267000000 275000000 283000000 291000000 299000000 307000000 315000000 323000000 331000000 339000000 347000000 355000000 "+
        "363000000 371000000 379000000 387000000 395000000 403000000 411000000 419000000 427000000 435000000 443000000 451000000 "+
        "459000000 467000000 474000000 482000000 490000000 498000000 506000000 514000000 522000000 530000000 538000000 546000000 "+
        "554000000 562000000 570000000 578000000 586000000 594000000 602000000 610000000 618000000 626000000 634000000 642000000 "+
        "650000000 658000000 666000000 674000000 682000000 690000000 698000000 706000000 714000000 722000000 730000000 738000000 "+
        "746000000 754000000 762000000 770000000 778000000 786000000 794000000 802000000 810000000 818000000 826000000 834000000 "+
        "842000000 850000000 858000000 866000000 874000000"),
    
    
    new TVRegion("Default ATSC-AIR-STD", TVChannelParams.MODE_ATSC,
    		"55.25 	61.25 	67.25 	77.25 	83.25 	175.25	181.25	187.25	193.25	199.25	205.25	211.25	471.25	477.25	483.25   489.25	" +
    		"495.25	501.25	507.25	513.25	519.25	525.25	531.25	537.25	543.25	549.25	555.25	561.25	567.25	573.25	579.25	585.25" + 
    		"591.25	597.25	603.25	609.25	615.25	621.25	627.25	633.25	639.25	645.25	651.25	657.25	663.25	669.25	675.25	681.25" +
    		"687.25	693.25  699.25	705.25	711.25	717.25	723.25  729.25	735.25	741.25	747.25	753.25	759.25	765.25	771.25	777.25" +
    		"783.25	789.25	795.25	801.25	807.25	813.25	819.25	825.25	831.25	837.25	843.25	849.25	855.25	861.25	867.25	873.25" +
    		"879.25	885.25"),
    	
    	
    	new TVRegion("Default ATSC-CABLE-STD", TVChannelParams.MODE_ATSC,
    	" 55.25   	61.25   	67.25   	77.25   	83.25   	175.25  	181.25  	187.25  	193.25  	199.25  	205.25  	211.25  " +
		" 121.2625	127.2625	133.2625	139.25  	145.25  	151.25  	157.25  	163.25  	169.25  	217.25  	223.25  	229.2625" +
		" 235.2625	241.2625	247.2625	253.2625	259.2625	265.2625	271.2625	277.2625	283.2625	289.2625	295.2625	301.2625" +
		" 307.2625	313.2625	319.2625	325.2625	331.275 	337.2625	343.2625	349.2625	355.2625	361.2625	367.2625	373.2625" +
		" 379.2625	385.2625	391.2625	397.2625	403.25  	409.25  	415.25  	421.25  	427.25  	433.25  	439.25  	445.25  " +
		" 451.25  	457.25  	463.25  	469.25  	475.25  	481.25      487.25  	493.25  		499.25  	505.25  511.25  	517.25  " +
		" 523.25  	529.25  535.25  	541.25  	547.25  	553.25  	559.25  	565.25  	571.25  	577.25  	583.25  	589.25      " +
		" 595.25  	601.25  	607.25  	613.25  	619.25  	625.25  	631.25  	637.25  	643.25  	91.25   	97.25   	103.25  " +
		" 109.275 	115.275 	649.25  	655.25  	661.25  667.25  	673.25  	679.25  	685.25  	691.25  	697.25  	703.25      " +
		" 709.25  	715.25  	721.25  	727.25  	733.25  	739.25  	745.25  	751.25  	757.25  	763.25  	769.25  	775.25  " +
		" 781.25  	787.25  	793.25  	799.25  	805.25  	811.25  	817.25  	823.25                                                  " +
		" 829.25  	835.25  	841.25  	847.25  	853.25  	859.25                                                                          " 
	    ),
	    
	    new TVRegion("Default ATSC-CABLE-IRC", TVChannelParams.MODE_ATSC,
		" 73.2625		55.2625 	61.2625 	67.2625 	79.2625 	85.2625 	175.2625	181.2625	187.2625	193.2625   199.2625 205.2625 " +
		" 211.2625	121.2625	127.2625	133.2625	139.2625	145.2625	151.2625	157.2625	163.2625	169.2625	217.2625	223.2625 " +
		" 229.2625	235.2625	241.2625	247.2625	253.2625	259.2625	265.2625	271.2625	277.2625	283.2625	289.2625	295.2625 " +
		" 301.2625	307.2625	313.2625	319.2625	325.2625	331.275 	337.2625	343.2625	349.2625	355.2625	361.2625	367.2625 " +
		" 373.2625	379.2625	385.2625	391.2625	397.2625	403.2625	409.2625	415.2625	421.2625	427.2625	433.2625	439.2625 " +
		" 445.2625	451.2625	457.2625	463.2625	469.2625	475.2625	481.2625	487.2625	493.2625	499.2625	505.2625	511.2625 " +
		" 517.2625	523.2625	529.2625	535.2625	541.2625	547.2625	553.2625	559.2625	565.2625	571.2625	577.2625	583.2625 " +
		" 589.2625	595.2625	601.2625	607.2625	613.2625	619.2625	625.2625	631.2625	637.2625	643.2625	91.2625 	97.2625  " +
		" 103.2625	109.275 	115.275 	649.2625	655.2625	661.2625	667.2625	673.2625	679.2625	685.2625	691.2625	697.2625 " +
		" 703.2625	709.2625	715.2625	721.2625	727.2625	733.2625	739.2625	745.2625	751.2625	757.2625	763.2625	769.2625 " +
		" 775.2625	781.2625	787.2625	793.2625	799.2625	805.2625	811.2625	817.2625	823.2625	829.2625	835.2625	841.2625 " +
		" 847.2625	853.2625	859.2625                                                                                                             "
	    ),
        
        new TVRegion("Default ATSC-CABLE-HRC", TVChannelParams.MODE_ATSC,
		" 72.0036 	54.0027 	60.0030 	66.0033 	78.0039 	84.0042 	174.0087	180.0090	186.0093	192.0096	198.0099	204.0102" +
    	" 210.0105	120.0060	126.0063	132.0066	138.0069	144.0072	150.0075	156.0078	162.0081	168.0084	216.0108	222.0111" +
		" 228.0114	234.0117	240.0120	246.0123	252.0126	258.0129	264.0132	270.0135	276.0138	282.0141	288.0144	294.0147" +
		" 300.0150	306.0153	312.0156	318.0159	324.0162	330.0165	336.0168	342.0171	348.0174	354.0177	360.0180	366.0183" +
		" 372.0186	378.0189	384.0192	390.0195	396.0198	402.0201	408.0204	414.0207	420.0210	426.0213	432.0216	438.0219" +
		" 444.0222	450.0225	456.0228	462.0231	468.0234	474.0237	480.0240	486.0243	492.0246	498.0249	504.0252	510.0255" +
		" 516.0258	522.0261	528.0264	534.0267	540.0270	546.0273	552.0276	558.0279	564.0282	570.0285	576.0288	582.0291" +
		" 588.0294	594.0297	600.0300	606.0303	612.0306	618.0309	624.0312	630.0315	636.0318	642.0321                        " +
		" 90.0045 	96.0048 	102.0051	108.0054	114.0057                                                                                    " +
		" 648.0324	654.0327	660.0330	666.0333	672.0336	678.0339	684.0342	690.0345	696.0348	702.0351	708.0354	714.0357" +
		" 720.0360	726.0363	732.0366	738.0369	744.0372	750.0375	756.0378	762.0381	768.0384	774.0387	780.0390	786.0393" +
		" 792.0396	798.0399	804.0402	810.0405	816.0408	822.0411	828.0414	834.0417	840.0420	846.0423	852.0426	858.0429" 
        ),
	    
        
        new TVRegion("Default CHINA-CABLE", TVChannelParams.MODE_ANALOG,
        " 49.75   57.75   65.75   77.25  85.25  112.25  120.25  128.25  136.25  144.25  152.25  160.25  168.25  176.25  184.25  192.25    " +
		" 200.25  208.25  216.25  224.25  232.25  240.25  248.25  256.25  264.25  272.25  280.25  288.25  296.25  304.25  312.25  320.25  " +
		" 328.25  336.25  344.25  352.25  360.25  368.25  376.25  384.25  392.25  400.25  408.25  416.25  424.25  432.25  440.25  448.25  " +
		" 456.25  471.25  479.25  487.25  495.25  503.25  511.25  519.25   527.25  535.25  543.25  551.25  559.25  567.25  575.25  583.25 " +
		" 591.25  599.25  607.25  615.25  623.25  631.25  639.25  647.25  655.25  663.25  671.25  679.25  687.25  695.25  703.25  711.25  " +
		" 719.25  727.25  735.25  743.25  751.25  759.25  767.25  775.25  783.25  791.25  799.25  807.25  815.25  823.25  831.25  839.25  " +
		" 847.25 855.25 868.25 																											  "
        ),
        		
        
        new TVRegion("Default CHINA-AIR", TVChannelParams.MODE_ANALOG,
		" 49.75   57.75  65.75   77.25  85.25   168.25  176.25  184.25  192.25  200.25                                                      " +
		" 208.25  216.25  471.25  479.25  487.25  495.25  503.25  511.25  519.25  527.25  525.25  543.25  551.25  559.25  607.25  615.25    " +
		" 623.25  631.25  639.25  647.25  655.25  663.25  671.25  679.25  687.25  695.25  703.25  711.25  719.25  727.25  735.25  743.25    " +
		" 751.25  759.25  767.25  775.25  783.25  791.25  799.25  807.25   715.25  823.25  831.25  839.25  847.25  855.25  863.25  871.25   " +
		" 879.25  887.25  895.25  903.25  911.25  919.25  927.25  935.25  943.25  951.25 													" 
        ),
       
	    };
    	
    	
    
    

    public synchronized static void openDatabase(Context context) {
        if(openCount == 0) {
            String path;
            SharedPreferences pref;

            db = new TVDatabase(context, null);
            TVDatabase fileDB = new TVDatabase(context, DB_NAME);
            path = new String(fileDB.getReadableDatabase().getPath());
            fileDB.close();
            /*Check the database version.*/
            pref = PreferenceManager.getDefaultSharedPreferences(context);
            int curVer = pref.getInt(DB_VERSION_FIELD, -1);
            if(curVer != TVDatabase.DB_VERSION) {
                File tmpFile = new File(path);
                pref.edit().putInt(DB_VERSION_FIELD, TVDatabase.DB_VERSION).commit();

                fileDB = new TVDatabase(context, DB_NAME);
                fileDB.close();
            }
            db.getWritableDatabase().execSQL("attach database '"+path+"' as filedb");
            db.getWritableDatabase().execSQL("insert into net_table select * from filedb.net_table");
            db.getWritableDatabase().execSQL("insert into ts_table select  * from filedb.ts_table");
            db.getWritableDatabase().execSQL("insert into srv_table select * from filedb.srv_table");
            db.getWritableDatabase().execSQL("insert into rec_table select * from filedb.rec_table");
            db.getWritableDatabase().execSQL("insert into grp_table select * from filedb.grp_table");
            db.getWritableDatabase().execSQL("insert into evt_table select * from filedb.evt_table");
            db.getWritableDatabase().execSQL("insert into subtitle_table select * from filedb.subtitle_table");
            db.getWritableDatabase().execSQL("insert into teletext_table select * from filedb.teletext_table");
            db.getWritableDatabase().execSQL("insert into dimension_table select * from filedb.dimension_table");
            db.getWritableDatabase().execSQL("insert into sat_para_table select * from filedb.sat_para_table");
            /** load the frequency lists from code*/
            ContentValues cv = new ContentValues();
            for (int i=0; i<tvRegions.length; i++) {
                Log.d(TAG, "Loading region "+tvRegions[i].name+", source "+tvRegions[i].source);
                cv.put("name", tvRegions[i].name);
                cv.put("source", tvRegions[i].source);
                cv.put("frequencies", tvRegions[i].freqList);
                db.getWritableDatabase().insert("region_table", "", cv);
                Log.d(TAG, tvRegions[i].name + " done !");
                cv.clear();
            }
        }

        openCount++;
    }

    public static synchronized void syncToFile() {
        if(db == null)
            return;

        db.getWritableDatabase().execSQL("drop table if exists filedb.net_table");
        db.getWritableDatabase().execSQL("drop table if exists filedb.ts_table");
        db.getWritableDatabase().execSQL("drop table if exists filedb.srv_table");
        db.getWritableDatabase().execSQL("drop table if exists filedb.grp_table");
        db.getWritableDatabase().execSQL("drop table if exists filedb.grp_map_table");
        db.getWritableDatabase().execSQL("drop table if exists filedb.subtitle_table");
        db.getWritableDatabase().execSQL("drop table if exists filedb.teletext_table");
        db.getWritableDatabase().execSQL("drop table if exists filedb.evt_table");
        db.getWritableDatabase().execSQL("drop table if exists filedb.dimension_table");
        db.getWritableDatabase().execSQL("drop table if exists filedb.sat_para_table");

        /*Store data from memory to file*/
        db.getWritableDatabase().execSQL("create table filedb.net_table as select * from net_table");
        db.getWritableDatabase().execSQL("create table filedb.ts_table as select * from ts_table");
        db.getWritableDatabase().execSQL("create table filedb.srv_table as select * from srv_table");
        db.getWritableDatabase().execSQL("create table filedb.grp_table as select * from grp_table");
        db.getWritableDatabase().execSQL("create table filedb.grp_map_table as select * from grp_map_table");
        db.getWritableDatabase().execSQL("create table filedb.subtitle_table as select * from subtitle_table");
        db.getWritableDatabase().execSQL("create table filedb.teletext_table as select * from teletext_table");
        db.getWritableDatabase().execSQL("create table filedb.evt_table as select * from evt_table where sub_flag!=0");
        db.getWritableDatabase().execSQL("create table filedb.dimension_table as select * from dimension_table");
        db.getWritableDatabase().execSQL("create table filedb.sat_para_table as select * from sat_para_table");
    }

    public synchronized static void closeDatabase(Context context) {
        if(openCount <= 0)
            return;

        openCount--;

        if((openCount == 0) && (db != null)) {
            Log.d(TAG, "close database");
            db.getWritableDatabase().execSQL("detach database filedb");
            db.close();
            db = null;
        }
    }

    public synchronized static int getDatabaseNativeHandle() {
        if (db == null) {
            return 0;
        }
        return db.getNativeHandle();
    }

    @Override
    public boolean onCreate() {
        openDatabase(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int id = URI_MATCHER.match(uri);
        Cursor c = null;

        if(id == RD_SQL) {
            c = db.getReadableDatabase().rawQuery(selection, null);
        } else if(id == WR_SQL) {
            db.getWritableDatabase().execSQL(selection);
        }

        return c;
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values,  String where, String[] whereArgs) {
        return 0;
    }
}

