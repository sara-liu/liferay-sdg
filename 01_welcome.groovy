import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
import com.liferay.portlet.social.service.SocialActivitySettingServiceUtil;

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

String settingsJSON = "{\"actions\":[{\"active\":true,\"activityType\"" +
	":2,\"contributionIncrement\":0,\"contributionLimitEnabled\":false," +
	"\"contributionLimitValue\":0,\"languageKey\":\"ADD_ENTRY\"," +
	"\"participationIncrement\":5,\"participationLimitEnabled\":true," +
	"\"participationLimitValue\":1},{\"active\":true,\"activityType\":10005," +
	"\"contributionIncrement\":2,\"contributionLimitEnabled\":true," +
	"\"contributionLimitValue\":0,\"languageKey\":\"ADD_COMMENT\"," +
	"\"participationIncrement\":2,\"participationLimitEnabled\":true," +
	"\"participationLimitValue\":10},{\"active\":true,\"activityType\":10001," +
	"\"contributionIncrement\":0,\"contributionLimitEnabled\":true," +
	"\"contributionLimitValue\":0,\"languageKey\":\"VIEW\"," +
	"\"participationIncrement\":1,\"participationLimitEnabled\":true," +
	"\"participationLimitValue\":0},{\"active\":true,\"activityType\":10002," +
	"\"contributionIncrement\":2,\"contributionLimitEnabled\":false," +
	"\"contributionLimitValue\":0,\"languageKey\":\"SUBSCRIBE\"," +
	"\"participationIncrement\":2,\"participationLimitEnabled\":true," +
	"\"participationLimitValue\":0},{\"active\":true,\"activityType\":10003," +
	"\"contributionIncrement\":0,\"contributionLimitEnabled\":false," +
	"\"contributionLimitValue\":0,\"languageKey\":\"UNSUBSCRIBE\"," +
	"\"participationIncrement\":0,\"participationLimitEnabled\":true," +
	"\"participationLimitValue\":0},{\"active\":true,\"activityType\":3," +
	"\"contributionIncrement\":0,\"contributionLimitEnabled\":true," +
	"\"contributionLimitValue\":0,\"languageKey\":\"UPDATE_ENTRY\"," +
	"\"participationIncrement\":1,\"participationLimitEnabled\":true," +
	"\"participationLimitValue\":10},{\"active\":true,\"activityType\":10004," +
	"\"contributionIncrement\":5,\"contributionLimitEnabled\":false," +
	"\"contributionLimitValue\":0,\"languageKey\":\"ADD_VOTE\"," +
	"\"participationIncrement\":1,\"participationLimitEnabled\":true," +
	"\"participationLimitValue\":0}],\"modelName\":" +
	"\"com.liferay.portlet.blogs.model.BlogsEntry\"}";

JSONObject settingsJSONObject = JSONFactoryUtil.createJSONObject(
	settingsJSON);

JSONArray actionsJSONArray = settingsJSONObject.getJSONArray("actions");

String modelName = settingsJSONObject.getString("modelName");

for (int i = 0; i < actionsJSONArray.length(); i++) {
	JSONObject actionJSONObject = actionsJSONArray.getJSONObject(i);

	int activityType = actionJSONObject.getInt("activityType");

	SocialActivityDefinition activityDefinition =
		SocialActivitySettingServiceUtil.getActivityDefinition(
			groupId, modelName, activityType);

	List<SocialActivityCounterDefinition> activityCounterDefinitions =
		new ArrayList<SocialActivityCounterDefinition>();

	activityCounterDefinitions.add(
		updateActivityCounterDefinition(
			actionJSONObject, activityDefinition,
			SocialActivityCounterConstants.NAME_CONTRIBUTION));

	activityCounterDefinitions.add(
		updateActivityCounterDefinition(
			actionJSONObject, activityDefinition,
			SocialActivityCounterConstants.NAME_PARTICIPATION));

	activityCounterDefinitions.add(
		updateActivityCounterDefinition(
			actionJSONObject, activityDefinition,
			SocialActivityCounterConstants.NAME_POPULARITY));

	SocialActivitySettingLocalServiceUtil.updateActivitySettings(
		groupId, modelName, activityType, activityCounterDefinitions);
}

protected SocialActivityCounterDefinition updateActivityCounterDefinition(
		JSONObject actionJSONObject,
		SocialActivityDefinition activityDefinition,
		String activityCounterName) {

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

		activityCounterName =
			SocialActivityCounterConstants.NAME_CONTRIBUTION;
	}

	activityCounterDefinition.setEnabled(actionJSONObject.getBoolean("active"));
	activityCounterDefinition.setIncrement(
		actionJSONObject.getInt(activityCounterName + "Increment"));
	activityCounterDefinition.setLimitPeriod(
		actionJSONObject.getInt(activityCounterName + "LimitPeriod"));
	activityCounterDefinition.setLimitValue(
		actionJSONObject.getInt(activityCounterName + "LimitValue"));

	return activityCounterDefinition;
}

SocialActivitySettingLocalServiceUtil.updateActivitySetting(
	groupId, modelName, true);
