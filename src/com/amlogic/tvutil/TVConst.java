package com.amlogic.tvutil;

public class TVConst{
    public static enum TVInTransFormat {
        TVIN_TFMT_2D,
        TVIN_TFMT_3D_LRH_OLOR,
        TVIN_TFMT_3D_LRH_OLER,
        TVIN_TFMT_3D_LRH_ELOR,
        TVIN_TFMT_3D_LRH_ELER,
        TVIN_TFMT_3D_TB,
        TVIN_TFMT_3D_FP,
        TVIN_TFMT_3D_FA,
        TVIN_TFMT_3D_LA,
        TVIN_TFMT_3D_LRF,
        TVIN_TFMT_3D_LD,
        TVIN_TFMT_3D_LDGD,
    };
    
    /* tvin signal format table */
    public static enum TVInSigFormat {
        TVIN_SIG_FMT_NULL,
        // VGA Formats
        TVIN_SIG_FMT_VGA_512X384P_60HZ_D147, // 1
        TVIN_SIG_FMT_VGA_560X384P_60HZ_D147,
        TVIN_SIG_FMT_VGA_640X200P_59HZ_D924,
        TVIN_SIG_FMT_VGA_640X350P_85HZ_D080,
        TVIN_SIG_FMT_VGA_640X400P_59HZ_D940,
        TVIN_SIG_FMT_VGA_640X400P_85HZ_D080,
        TVIN_SIG_FMT_VGA_640X400P_59HZ_D638,
        TVIN_SIG_FMT_VGA_640X400P_56HZ_D416,
        TVIN_SIG_FMT_VGA_640X480P_66HZ_D619,
        TVIN_SIG_FMT_VGA_640X480P_66HZ_D667, // 10
        TVIN_SIG_FMT_VGA_640X480P_59HZ_D940,
        TVIN_SIG_FMT_VGA_640X480P_60HZ_D000,
        TVIN_SIG_FMT_VGA_640X480P_72HZ_D809,
        TVIN_SIG_FMT_VGA_640X480P_75HZ_D000_A,
        TVIN_SIG_FMT_VGA_640X480P_85HZ_D008,
        TVIN_SIG_FMT_VGA_640X480P_59HZ_D638,
        TVIN_SIG_FMT_VGA_640X480P_75HZ_D000_B,
        TVIN_SIG_FMT_VGA_640X870P_75HZ_D000,
        TVIN_SIG_FMT_VGA_720X350P_70HZ_D086,
        TVIN_SIG_FMT_VGA_720X400P_85HZ_D039, // 20
        TVIN_SIG_FMT_VGA_720X400P_70HZ_D086,
        TVIN_SIG_FMT_VGA_720X400P_87HZ_D849,
        TVIN_SIG_FMT_VGA_720X400P_59HZ_D940,
        TVIN_SIG_FMT_VGA_720X480P_59HZ_D940,
        TVIN_SIG_FMT_VGA_768X480P_59HZ_D896,
        TVIN_SIG_FMT_VGA_800X600P_56HZ_D250,
        TVIN_SIG_FMT_VGA_800X600P_60HZ_D000,
        TVIN_SIG_FMT_VGA_800X600P_60HZ_D000_A,
        TVIN_SIG_FMT_VGA_800X600P_60HZ_D317,
        TVIN_SIG_FMT_VGA_800X600P_72HZ_D188, // 30
	TVIN_SIG_FMT_VGA_800X600P_75HZ_D000,
        TVIN_SIG_FMT_VGA_800X600P_85HZ_D061,
        TVIN_SIG_FMT_VGA_832X624P_75HZ_D087,
        TVIN_SIG_FMT_VGA_848X480P_84HZ_D751,
        TVIN_SIG_FMT_VGA_960X600P_59HZ_D635,
        TVIN_SIG_FMT_VGA_1024X768P_59HZ_D278,
        TVIN_SIG_FMT_VGA_1024X768P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1024X768P_60HZ_D000_A,
        TVIN_SIG_FMT_VGA_1024X768P_60HZ_D000_B,
        TVIN_SIG_FMT_VGA_1024X768P_74HZ_D927, // 40
        TVIN_SIG_FMT_VGA_1024X768P_60HZ_D004,
        TVIN_SIG_FMT_VGA_1024X768P_70HZ_D069,
        TVIN_SIG_FMT_VGA_1024X768P_75HZ_D029,
        TVIN_SIG_FMT_VGA_1024X768P_84HZ_D997,
        TVIN_SIG_FMT_VGA_1024X768P_74HZ_D925,
        TVIN_SIG_FMT_VGA_1024X768P_75HZ_D020,
        TVIN_SIG_FMT_VGA_1024X768P_70HZ_D008,
        TVIN_SIG_FMT_VGA_1024X768P_75HZ_D782,
        TVIN_SIG_FMT_VGA_1024X768P_77HZ_D069,
        TVIN_SIG_FMT_VGA_1024X768P_71HZ_D799, // 50
        TVIN_SIG_FMT_VGA_1024X1024P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1152X864P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1152X864P_70HZ_D012,
        TVIN_SIG_FMT_VGA_1152X864P_75HZ_D000,
        TVIN_SIG_FMT_VGA_1152X864P_84HZ_D999,
        TVIN_SIG_FMT_VGA_1152X870P_75HZ_D062,
        TVIN_SIG_FMT_VGA_1152X900P_65HZ_D950,
        TVIN_SIG_FMT_VGA_1152X900P_66HZ_D004,
        TVIN_SIG_FMT_VGA_1152X900P_76HZ_D047,
        TVIN_SIG_FMT_VGA_1152X900P_76HZ_D149, // 60
        TVIN_SIG_FMT_VGA_1280X720P_59HZ_D855,
        TVIN_SIG_FMT_VGA_1280X720P_60HZ_D000_A,
        TVIN_SIG_FMT_VGA_1280X720P_60HZ_D000_B,
        TVIN_SIG_FMT_VGA_1280X720P_60HZ_D000_C,
        TVIN_SIG_FMT_VGA_1280X720P_60HZ_D000_D,
        TVIN_SIG_FMT_VGA_1280X768P_59HZ_D870,
        TVIN_SIG_FMT_VGA_1280X768P_59HZ_D995,
        TVIN_SIG_FMT_VGA_1280X768P_60HZ_D100,
        TVIN_SIG_FMT_VGA_1280X768P_60HZ_D100_A,
        TVIN_SIG_FMT_VGA_1280X768P_74HZ_D893, // 70
        TVIN_SIG_FMT_VGA_1280X768P_84HZ_D837,
        TVIN_SIG_FMT_VGA_1280X800P_59HZ_D810,
        TVIN_SIG_FMT_VGA_1280X800P_59HZ_D810_A,
        TVIN_SIG_FMT_VGA_1280X800P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1280X800P_60HZ_D000_A,
        TVIN_SIG_FMT_VGA_1280X960P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1280X960P_60HZ_D000_A,
        TVIN_SIG_FMT_VGA_1280X960P_75HZ_D000,
        TVIN_SIG_FMT_VGA_1280X960P_85HZ_D002,
        TVIN_SIG_FMT_VGA_1280X1024P_60HZ_D020, // 80
	TVIN_SIG_FMT_VGA_1280X1024P_60HZ_D020_A,
        TVIN_SIG_FMT_VGA_1280X1024P_75HZ_D025,
        TVIN_SIG_FMT_VGA_1280X1024P_85HZ_D024,
        TVIN_SIG_FMT_VGA_1280X1024P_59HZ_D979,
        TVIN_SIG_FMT_VGA_1280X1024P_72HZ_D005,
        TVIN_SIG_FMT_VGA_1280X1024P_60HZ_D002,
        TVIN_SIG_FMT_VGA_1280X1024P_67HZ_D003,
        TVIN_SIG_FMT_VGA_1280X1024P_74HZ_D112,
        TVIN_SIG_FMT_VGA_1280X1024P_76HZ_D179,
        TVIN_SIG_FMT_VGA_1280X1024P_66HZ_D718, // 90
        TVIN_SIG_FMT_VGA_1280X1024P_66HZ_D677,
        TVIN_SIG_FMT_VGA_1280X1024P_76HZ_D107,
        TVIN_SIG_FMT_VGA_1280X1024P_59HZ_D996,
        TVIN_SIG_FMT_VGA_1280X1024P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1360X768P_59HZ_D799,
        TVIN_SIG_FMT_VGA_1360X768P_60HZ_D015,
        TVIN_SIG_FMT_VGA_1360X768P_60HZ_D015_A,
        TVIN_SIG_FMT_VGA_1360X850P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1360X1024P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1366X768P_59HZ_D790, // 100
        TVIN_SIG_FMT_VGA_1366X768P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1400X1050P_59HZ_D978,
        TVIN_SIG_FMT_VGA_1440X900P_59HZ_D887,
        TVIN_SIG_FMT_VGA_1440X1080P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1600X900P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1600X1024P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1600X1200P_59HZ_D869,
        TVIN_SIG_FMT_VGA_1600X1200P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1600X1200P_65HZ_D000,
        TVIN_SIG_FMT_VGA_1600X1200P_70HZ_D000,
        TVIN_SIG_FMT_VGA_1680X1050P_59HZ_D954,  // 110
	TVIN_SIG_FMT_VGA_1680X1080P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1920X1080P_49HZ_D929,
        TVIN_SIG_FMT_VGA_1920X1080P_59HZ_D963_A,
        TVIN_SIG_FMT_VGA_1920X1080P_59HZ_D963,
        TVIN_SIG_FMT_VGA_1920X1080P_60HZ_D000,
        TVIN_SIG_FMT_VGA_1920X1200P_59HZ_D950,
        TVIN_SIG_FMT_VGA_1024X768P_60HZ_D000_C,
        TVIN_SIG_FMT_VGA_1024X768P_60HZ_D000_D,
        TVIN_SIG_FMT_VGA_RESERVE3,
        TVIN_SIG_FMT_VGA_RESERVE4,
        TVIN_SIG_FMT_VGA_RESERVE5,
        TVIN_SIG_FMT_VGA_RESERVE6,
        TVIN_SIG_FMT_VGA_RESERVE7,
        TVIN_SIG_FMT_VGA_RESERVE8,
        TVIN_SIG_FMT_VGA_RESERVE9,
        TVIN_SIG_FMT_VGA_RESERVE10,
        TVIN_SIG_FMT_VGA_RESERVE11,
        TVIN_SIG_FMT_VGA_RESERVE12,
        TVIN_SIG_FMT_VGA_MAX,
        // Component Formats
        TVIN_SIG_FMT_COMP_480P_60HZ_D000,
        TVIN_SIG_FMT_COMP_480I_60HZ_D940,
        TVIN_SIG_FMT_COMP_576P_50HZ_D000,
        TVIN_SIG_FMT_COMP_576I_50HZ_D000,
        TVIN_SIG_FMT_COMP_720P_60HZ_D940,
        TVIN_SIG_FMT_COMP_720P_50HZ_D000,
        TVIN_SIG_FMT_COMP_1080P_23HZ_D976,
        TVIN_SIG_FMT_COMP_1080P_24HZ_D000,
        TVIN_SIG_FMT_COMP_1080P_25HZ_D000,
        TVIN_SIG_FMT_COMP_1080P_30HZ_D000,
        TVIN_SIG_FMT_COMP_1080P_50HZ_D000,
        TVIN_SIG_FMT_COMP_1080P_60HZ_D000,
        TVIN_SIG_FMT_COMP_1080I_47HZ_D952,
        TVIN_SIG_FMT_COMP_1080I_48HZ_D000,
        TVIN_SIG_FMT_COMP_1080I_50HZ_D000_A,
        TVIN_SIG_FMT_COMP_1080I_50HZ_D000_B,
        TVIN_SIG_FMT_COMP_1080I_50HZ_D000_C,
        TVIN_SIG_FMT_COMP_1080I_60HZ_D000,
        TVIN_SIG_FMT_COMP_MAX,
	// HDMI Formats
        TVIN_SIG_FMT_HDMI_640X480P_60HZ,
        TVIN_SIG_FMT_HDMI_720X480P_60HZ,
        TVIN_SIG_FMT_HDMI_1280X720P_60HZ,
        TVIN_SIG_FMT_HDMI_1920X1080I_60HZ,
        TVIN_SIG_FMT_HDMI_1440X480I_60HZ,
        TVIN_SIG_FMT_HDMI_1440X240P_60HZ,
        TVIN_SIG_FMT_HDMI_2880X480I_60HZ,
        TVIN_SIG_FMT_HDMI_2880X240P_60HZ,
        TVIN_SIG_FMT_HDMI_1440X480P_60HZ,
        TVIN_SIG_FMT_HDMI_1920X1080P_60HZ,
        TVIN_SIG_FMT_HDMI_720X576P_50HZ,
        TVIN_SIG_FMT_HDMI_1280X720P_50HZ,
        TVIN_SIG_FMT_HDMI_1920X1080I_50HZ_A,
        TVIN_SIG_FMT_HDMI_1440X576I_50HZ,
        TVIN_SIG_FMT_HDMI_1440X288P_50HZ,
        TVIN_SIG_FMT_HDMI_2880X576I_50HZ,
        TVIN_SIG_FMT_HDMI_2880X288P_50HZ,
        TVIN_SIG_FMT_HDMI_1440X576P_50HZ,
        TVIN_SIG_FMT_HDMI_1920X1080P_50HZ,
        TVIN_SIG_FMT_HDMI_1920X1080P_24HZ,
        TVIN_SIG_FMT_HDMI_1920X1080P_25HZ,
        TVIN_SIG_FMT_HDMI_1920X1080P_30HZ,
        TVIN_SIG_FMT_HDMI_2880X480P_60HZ,
        TVIN_SIG_FMT_HDMI_2880X576P_60HZ,
        TVIN_SIG_FMT_HDMI_1920X1080I_50HZ_B,
        TVIN_SIG_FMT_HDMI_1920X1080I_100HZ,
        TVIN_SIG_FMT_HDMI_1280X720P_100HZ,
        TVIN_SIG_FMT_HDMI_720X576P_100HZ,
        TVIN_SIG_FMT_HDMI_1440X576I_100HZ,
        TVIN_SIG_FMT_HDMI_1920X1080I_120HZ,
        TVIN_SIG_FMT_HDMI_1280X720P_120HZ,
        TVIN_SIG_FMT_HDMI_720X480P_120HZ,
        TVIN_SIG_FMT_HDMI_1440X480I_120HZ,
        TVIN_SIG_FMT_HDMI_720X576P_200HZ,
        TVIN_SIG_FMT_HDMI_1440X576I_200HZ,
        TVIN_SIG_FMT_HDMI_720X480P_240HZ,
        TVIN_SIG_FMT_HDMI_1440X480I_240HZ,
        TVIN_SIG_FMT_HDMI_1280X720P_24HZ,
        TVIN_SIG_FMT_HDMI_1280X720P_25HZ,
        TVIN_SIG_FMT_HDMI_1280X720P_30HZ,
        TVIN_SIG_FMT_HDMI_1920X1080P_120HZ,
        TVIN_SIG_FMT_HDMI_1920X1080P_100HZ,
        TVIN_SIG_FMT_HDMI_1280X720P_60HZ_FRAME_PACKING,
        TVIN_SIG_FMT_HDMI_1280X720P_50HZ_FRAME_PACKING,
        TVIN_SIG_FMT_HDMI_1280X720P_24HZ_FRAME_PACKING,
        TVIN_SIG_FMT_HDMI_1280X720P_30HZ_FRAME_PACKING,
        TVIN_SIG_FMT_HDMI_1920X1080I_60HZ_FRAME_PACKING,
        TVIN_SIG_FMT_HDMI_1920X1080I_50HZ_FRAME_PACKING,
        TVIN_SIG_FMT_HDMI_1920X1080P_24HZ_FRAME_PACKING,
	TVIN_SIG_FMT_HDMI_1920X1080P_30HZ_FRAME_PACKING,
        TVIN_SIG_FMT_HDMI_800X600_00HZ,
        TVIN_SIG_FMT_HDMI_1024X768_00HZ,
        TVIN_SIG_FMT_HDMI_720X400_00HZ,
        TVIN_SIG_FMT_HDMI_1280X768_00HZ,
        TVIN_SIG_FMT_HDMI_1280X800_00HZ,
        TVIN_SIG_FMT_HDMI_1280X960_00HZ,
        TVIN_SIG_FMT_HDMI_1280X1024_00HZ,
        TVIN_SIG_FMT_HDMI_1360X768_00HZ,
        TVIN_SIG_FMT_HDMI_1366X768_00HZ,
        TVIN_SIG_FMT_HDMI_1600X1200_00HZ,
        TVIN_SIG_FMT_HDMI_1920X1200_00HZ,
        TVIN_SIG_FMT_HDMI_1440X900_00HZ,
        TVIN_SIG_FMT_HDMI_1400X1050_00HZ,
        TVIN_SIG_FMT_HDMI_1680X1050_00HZ,
        TVIN_SIG_FMT_HDMI_RESERVE1,
        TVIN_SIG_FMT_HDMI_RESERVE2,
        TVIN_SIG_FMT_HDMI_RESERVE3,
        TVIN_SIG_FMT_HDMI_RESERVE4,
        TVIN_SIG_FMT_HDMI_RESERVE5,
        TVIN_SIG_FMT_HDMI_RESERVE6,
        TVIN_SIG_FMT_HDMI_RESERVE7,
        TVIN_SIG_FMT_HDMI_RESERVE8,
        TVIN_SIG_FMT_HDMI_RESERVE9,
        TVIN_SIG_FMT_HDMI_RESERVE10,
        TVIN_SIG_FMT_HDMI_RESERVE11,
        TVIN_SIG_FMT_HDMI_720X480P_60HZ_FRAME_PACKING,
        TVIN_SIG_FMT_HDMI_720X576P_50HZ_FRAME_PACKING,
        TVIN_SIG_FMT_HDMI_MAX,
        // Video Formats
        TVIN_SIG_FMT_CVBS_NTSC_M,
        TVIN_SIG_FMT_CVBS_NTSC_443,
        TVIN_SIG_FMT_CVBS_PAL_I,
        TVIN_SIG_FMT_CVBS_PAL_M,
        TVIN_SIG_FMT_CVBS_PAL_60,
        TVIN_SIG_FMT_CVBS_PAL_CN,
        TVIN_SIG_FMT_CVBS_SECAM,
        // 656 Formats
        TVIN_SIG_FMT_BT656IN_576I_50HZ,
        TVIN_SIG_FMT_BT656IN_480I_60HZ,
        // 601 Formats
        TVIN_SIG_FMT_BT601IN_576I_50HZ,
        TVIN_SIG_FMT_BT601IN_480I_60HZ,
        // Camera Formats
        TVIN_SIG_FMT_CAMERA_640X480P_30HZ,
        TVIN_SIG_FMT_CAMERA_800X600P_30HZ,
        TVIN_SIG_FMT_CAMERA_1024X768P_30HZ,
        TVIN_SIG_FMT_CAMERA_1920X1080P_30HZ,
        TVIN_SIG_FMT_CAMERA_1280X720P_30HZ,
        TVIN_SIG_FMT_MAX,
    }

    // tvin signal status
    public enum TVInSigStatus {
        TVIN_SIG_STATUS_NULL,
        TVIN_SIG_STATUS_NOSIG,
        TVIN_SIG_STATUS_UNSTABLE,
        TVIN_SIG_STATUS_NOTSUP,
        TVIN_SIG_STATUS_STABLE,
    }

    // tvin status
    public enum TVInStatus {
        TVIN_STATUS_IDLE,
        TVIN_STATUS_PREVIEW_START,
        TVIN_STATUS_PREVIEW_STOP,
        TVIN_STATUS_NORMAL_START,
        TVIN_STATUS_NORMAL_STOP,
    }

    // Source input type
    public enum SourceType {
        SOURCE_TYPE_ATV,
        SOURCE_TYPE_AV,
        SOURCE_TYPE_COMPONENT,
        SOURCE_TYPE_HDMI,
        SOURCE_TYPE_VGA,
        SOURCE_TYPE_MPEG,
        SOURCE_TYPE_DTV,
        SOURCE_TYPE_MAX,
    }
}
