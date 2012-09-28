package com.amlogic.tvservice;

import com.amlogic.tvutil.TVProgramNumber;
import com.amlogic.tvutil.TVPlayParams;
import com.amlogic.tvutil.TVScanParams;
import com.amlogic.tvutil.TVConfigValue;
import com.amlogic.tvutil.ITVCallback;

//TV Service接口
interface ITVService{
	//注册消息回调
	void registerCallback(ITVCallback cb);

	//注销消息回调
	void unregisterCallback(ITVCallback cb);

	//设定配置项
	void setConfig(String name, in TVConfigValue value);

	//读取配置项
	TVConfigValue getConfig(String name);

	//注册配置项回调
	void registerConfigCallback(String name, ITVCallback cb);

	//注销配置项回调
	void unregisterConfigCallback(String name, ITVCallback cb);

	//取得当前TV时间(单位为毫秒)
	long getTime();

	//设定输入源
	void setInputSource(int source);

	//开始播放
	void playProgram(in TVPlayParams tp);

	//停止播放
	void stopPlaying();

	//开始时移播放
	void startTimeshifting();

	//开始录像
	void startRecording(int bookingID);

	//停止录像
	void stopRecording();

	//开始回放
	void startPlayback(int bookingID);

	//开始搜索
	void startScan(in TVScanParams sp);

	//停止搜索
	void stopScan(boolean store);

	//暂停播放(回放和时移)
	void pause();

	//恢复播放(回放和时移)
	void resume();

	//快进(回放和时移)
	void fastForward(int speed);

	//快退(回放和时移)
	void fastBackward(int speed);

	//移动到指定位置(回放和时移)
	void seekTo(int pos);
}
