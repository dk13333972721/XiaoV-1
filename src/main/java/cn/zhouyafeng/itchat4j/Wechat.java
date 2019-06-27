package cn.zhouyafeng.itchat4j;

import static org.androidtest.vince.data.Constant.groupList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.androidtest.vince.Config;
import org.androidtest.vince.customized.Customized;
import org.androidtest.vince.data.Constant;
import org.androidtest.vince.data.Group;
import org.androidtest.vince.publicutil.LogUtil;
import org.androidtest.vince.publicutil.StringUtil;
import org.androidtest.vince.publicutil.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.zhouyafeng.itchat4j.controller.LoginController;
import cn.zhouyafeng.itchat4j.core.MsgCenter;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;

public class Wechat {
	private static final Logger LOG = LoggerFactory.getLogger(Wechat.class);
	private IMsgHandlerFace msgHandler;

	public Wechat(IMsgHandlerFace msgHandler) {
		System.setProperty("jsse.enableSNIExtension", "false"); // 防止SSL错误
		this.msgHandler = msgHandler;
		LOG.info("0. 初始化群白名单和对应管理员信息");
		Config.initGroupAndAdmin();
		// 登陆
		LoginController login = new LoginController();
		login.login(Constant.OUTPUT_PATH.getAbsolutePath());
	}

	public void start() {
		LOG.info("+++++++++++++++++++开始消息处理+++++++++++++++++++++");
		new Thread(new Runnable() {
			@Override
			public void run() {
				MsgCenter.handleMsg(msgHandler);
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				setBoardcastListener();
			}
		}).start();
	}

	private void setBoardcastListener() {
		while (true) {
			boolean isReported = false;
			for (Group currentGroup : groupList) {
				List<Customized> customizedList = currentGroup
						.getCustomizedList();
				if (StringUtil.ifNotNullOrEmpty(customizedList)) {
					for (Customized customized : customizedList) {
						boolean result = customized
								.reportProcessRegularly(currentGroup);
						if (result && isReported == false) {
							isReported = true;
						}
					}
				}
				// List<Reminder> reminderlList =
				// currentGroup.getReminderList();
				// if (StringUtil.ifNotNullOrEmpty(reminderlList)) {
				// for (Reminder reminder : reminderlList) {
				// boolean result = reminder
				// .reminderRegularly(currentGroup);
				// if (result && isReported == false) {
				// isReported = true;
				// }
				// }
				// }
			}
			if (isReported) {
				LogUtil.MSG.debug("setBoardcastListener: " + "isReported "
						+ isReported);
				isReported = false;
				ThreadUtil.sleep(70 * 1000);// 执行完一轮后需要停止超过1分钟，避免重复报
			} else {
				try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}