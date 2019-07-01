package org.androidtest.xiaoV;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.androidtest.xiaoV.data.Constant;
import org.androidtest.xiaoV.data.Group;
import org.androidtest.xiaoV.factory.ActionFactory;

/**
 * 配置类
 *
 * @author caipeipei
 */
public class Config {

	public static final boolean DEBUG = false;// 全局的代码调试开关，打开后会一键进行测试模块，会在短时间里把各个组件的主动触发功能执行一遍

	/**
	 * 需要配置的群白名单和该群所需的组件信息。 可选组件的工厂见org.androidtest.vince.factory
	 */
	public static void initGroupAndAdmin() {
		Group group = new Group("彭于晏已退出群聊", Constant.DEFAULT_ADMIN);// 新建群信息
		group.addAction(ActionFactory.createMenuAction());// 配置该群有菜单功能
		group.addAction(ActionFactory.createGroupRuleAction(
				group.getGroupNickName(),
				new File(System.getProperty("user.home") + File.separator
						+ "Desktop" + File.separator + "彭于晏已退出群聊.jpg")));// 配置该群有规则提醒功能
		group.addAction(ActionFactory.createWeeklySportClockIn(2));// 配置该群有运动打卡功能，要求一周2次打卡
		group.addAction(ActionFactory.createDailyStepClockIn());// 配置该群有每日步数功能
		group.addAction(ActionFactory.createLifeRoutineClockInAction(true,
				0731, true, 2245));// 配置该群有作息打卡功能，设定每天0731晚起提醒和2230睡觉提醒
		group.addAction(ActionFactory.createWeeklyReportClockInAction(7, 2));// 配置该群有周报功能，周报功能会统计并播报运动打卡和每日步数数据
		Map<String, File> whiteList = new HashMap<String, File>();
		whiteList.put("Vince蔡培培", new File(System.getProperty("user.home")
				+ File.separator + "Desktop" + File.separator
				+ "DAILY CHECK LIST @Vince蔡培培.xlsx"));
		whiteList.put("王快乐。", new File(System.getProperty("user.home")
				+ File.separator + "Desktop" + File.separator
				+ "DAILY CHECK LIST @王快乐.xlsx"));
		group.addAction(ActionFactory.createDailySelfReflectionAction(
				whiteList, true));// 配置该群有每日反思打卡功能，需要配置反思人及对应的反思excel文件地址
		Constant.groupList.add(group);
		// //////////////////////////////////////////////
		Group group2 = new Group("运动 or  2000", Constant.DEFAULT_ADMIN);// 新建群信息
		group2.addAction(ActionFactory.createMenuAction());// 配置该群有菜单功能
		group2.addAction(ActionFactory.createGroupRuleAction(
				group2.getGroupNickName(),
				new File(System.getProperty("user.home") + File.separator
						+ "Desktop" + File.separator + "运动or2000.jpg")));// 配置该群有规则提醒功能
		group2.addAction(ActionFactory.createWeeklySportClockIn(1, true));// 配置该群有运动打卡功能，要求一周2次打卡
		group2.addAction(ActionFactory.createDailyStepClockIn(2, true));// 配置该群有每日步数功能
		group2.addAction(ActionFactory.createWeeklyReportClockInAction(2, 1));// 配置该群有周报功能，周报功能会统计并播报运动打卡和每日步数数据
		String text = "注意事项如下：\n1️⃣把群昵称改成自己的名字。\n2️⃣及时打卡，当天运动当天打卡，当天走万步当天打卡。\n3️⃣打卡形式为回复关键字+运动截图。\n4️⃣取消女生生理期请假，生理期当周请完成3次万步。\n5️⃣打卡务必输入关键字，若不清楚关键字，可在群里输入“菜单”查询。";
		group2.addAction(ActionFactory.createGroupAttentionAction(text));
		Constant.groupList.add(group2);
		// //////////////////////////////////////////////
		Group group3 = new Group("TEST123", Constant.DEFAULT_ADMIN);// 新建群信息
		group3.addAction(ActionFactory.createMenuAction());// 配置该群有菜单功能
		group3.addAction(ActionFactory.createWeeklySportClockIn(1, true));// 配置该群有运动打卡功能，要求一周2次打卡
		group3.addAction(ActionFactory.createDailyStepClockIn(2, true));// 配置该群有每日步数功能
		group3.addAction(ActionFactory.createWeeklyReportClockInAction(2, 1));// 配置该群有周报功能，周报功能会统计并播报运动打卡和每日步数数据
		group3.addAction(ActionFactory.createGroupAttentionAction(text));
		group3.addAction(ActionFactory.createGroupRuleAction(
				group3.getGroupNickName(),
				new File(System.getProperty("user.home") + File.separator
						+ "Desktop" + File.separator + "TEST123.jpg")));// 配置该群有规则提醒功能

		Constant.groupList.add(group3);
	}

}
