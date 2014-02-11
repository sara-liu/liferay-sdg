import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivityCounterConstants;
import com.liferay.portlet.social.model.SocialActivityCounterDefinition;
import com.liferay.portlet.social.model.SocialActivityDefinition;
import com.liferay.portlet.social.service.SocialActivitySettingLocalServiceUtil;

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

userId = PortalUtil.getUserId(actionRequest);

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	actionRequest);

serviceContext.setScopeGroupId(groupId);

// Welcome

Layout welcomeLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/home");

LayoutTypePortlet welcomeLayoutTypePortlet =
	(LayoutTypePortlet)welcomeLayout.getLayoutType();

welcomeLayoutTypePortlet.removePortletId(userId, "47");

welcomeLayoutTypePortlet.movePortletId(userId, "58", "column-2", -1);

welcomeLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_WelcomSM0001", "column-1", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, welcomeLayout.getLayoutId(),
	welcomeLayout.getTypeSettings());

// Add categories

AssetVocabulary assetVocabulary =
	AssetVocabularyLocalServiceUtil.addDefaultVocabulary(groupId);

AssetCategoryLocalServiceUtil.addCategory(
	userId, "category1", assetVocabulary.getVocabularyId(), serviceContext);

AssetCategoryLocalServiceUtil.addCategory(
	userId, "category2", assetVocabulary.getVocabularyId(), serviceContext);

// Enable Social Activity

String [][] socialActivitySettings =
	[[true, 2, 0, false, 0, "ADD_ENTRY", 5, true, 1],
	[true, 10005, 2, true, 0, "ADD_COMMENT", 2, true, 10],
	[true, 10001, 0, true, 0, "VIEW", 1, true, 0],
	[true, 10002, 2, false, 0, "SUBSCRIBE", 2, true, 0],
	[true, 10003, 0, false, 0, "UNSUBSCRIBE", 0, true, 0],
	[true, 3, 0, true, 0, "UPDATE_ENTRY", 1, true, 10],
	[true, 10004, 5, false, 0, "ADD_VOTE", 1, true, 0]];

String className = "com.liferay.portlet.blogs.model.BlogsEntry";

SocialActivityCounterDefinition updateActivityCounterDefinition(
		SocialActivityDefinition activityDefinition, String activityCounterName,
		boolean active, int increment, int limitValue) {

	SocialActivityCounterDefinition activityCounterDefinition =
		activityDefinition.getActivityCounterDefinition(activityCounterName);

	if (activityCounterDefinition == null) {
		activityCounterDefinition = new SocialActivityCounterDefinition();

		activityCounterDefinition.setName(activityCounterName);
	}

	if (activityCounterName.equals(
		SocialActivityCounterConstants.NAME_CONTRIBUTION)) {

		activityCounterDefinition.setOwnerType(
			SocialActivityCounterConstants.TYPE_CREATOR);
	}
	else if (activityCounterName.equals(
		SocialActivityCounterConstants.NAME_PARTICIPATION)) {

		activityCounterDefinition.setOwnerType(
			SocialActivityCounterConstants.TYPE_ACTOR);
	}
	else if (activityCounterName.equals(
		SocialActivityCounterConstants.NAME_POPULARITY)) {

		activityCounterDefinition.setOwnerType(
			SocialActivityCounterConstants.TYPE_ASSET);

		activityCounterName = SocialActivityCounterConstants.NAME_CONTRIBUTION;
	}

	activityCounterDefinition.setEnabled(active);
	activityCounterDefinition.setIncrement(increment);
	activityCounterDefinition.setLimitPeriod(0);
	activityCounterDefinition.setLimitValue(limitValue);

	return activityCounterDefinition;
}

for (int i = 0; i < socialActivitySettings.length; i++) {

	String[] socialActivitySetting = socialActivitySettings[i];

	int activityType = Integer.valueOf(socialActivitySetting[1]);

	SocialActivityDefinition activityDefinition =
		SocialActivitySettingLocalServiceUtil.getActivityDefinition(
			groupId, className, activityType);

	boolean active = Boolean.valueOf(socialActivitySetting[0]);

	int contrubutionIncrement = Integer.valueOf(socialActivitySetting[2]);
	int contrubutionLimitValue = Integer.valueOf(socialActivitySetting[4]);
	int participationIncrement = Integer.valueOf(socialActivitySetting[6]);
	int paticipationLimitValue = Integer.valueOf(socialActivitySetting[8]);

	List<SocialActivityCounterDefinition> activityCounterDefinitions =
		new ArrayList<SocialActivityCounterDefinition>();

	activityCounterDefinitions.add(
		updateActivityCounterDefinition(
			activityDefinition, "contribution", active, contrubutionIncrement,
			contrubutionLimitValue));

	activityCounterDefinitions.add(
		updateActivityCounterDefinition(
			activityDefinition, "participation", active, participationIncrement,
			paticipationLimitValue));

	activityCounterDefinitions.add(
		updateActivityCounterDefinition(
			activityDefinition, "popularity", active, contrubutionIncrement,
			contrubutionLimitValue));

	SocialActivitySettingLocalServiceUtil.updateActivitySettings(
		groupId, className, activityType, activityCounterDefinitions);
}

SocialActivitySettingLocalServiceUtil.updateActivitySetting(
	groupId, className, true);
