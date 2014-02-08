import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.NoSuchEntryException;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivityCounterConstants;
import com.liferay.portlet.social.model.SocialActivityCounterDefinition;
import com.liferay.portlet.social.model.SocialActivityDefinition;
import com.liferay.portlet.social.service.SocialActivityCounterLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivitySettingLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivitySettingServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

userId = PortalUtil.getUserId(actionRequest);

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	actionRequest);

serviceContext.setScopeGroupId(groupId);

// Social

Layout socialLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Social", "", "", "link_to_layout", false,
	"/social", serviceContext);

// Activities

Layout activitiesLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, socialLayout.getLayoutId(), "Activities", "", "",
	"portlet", false, "/activities", serviceContext);

LayoutTypePortlet activitiesLayoutTypePortlet =
	(LayoutTypePortlet)activitiesLayout.getLayoutType();

activitiesLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SocialSM0001", "column-1", -1, false);
activitiesLayoutTypePortlet.addPortletId(userId, "116", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, activitiesLayout.getLayoutId(),
	activitiesLayout.getTypeSettings());

// Group Statistics

Layout groupStatisticsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, socialLayout.getLayoutId(), "Group Statistics", "",
	"", "portlet", false, "/group-statistics", serviceContext);

LayoutTypePortlet groupStatisticsLayoutTypePortlet =
	(LayoutTypePortlet)groupStatisticsLayout.getLayoutType();

groupStatisticsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SocialSM0002", "column-1", -1, false);
groupStatisticsLayoutTypePortlet.addPortletId(
	userId, "181", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, groupStatisticsLayout.getLayoutId(),
	groupStatisticsLayout.getTypeSettings());

PortletPreferences groupStatisticsPortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		groupStatisticsLayout.getPlid(), "181",
		PortletConstants.DEFAULT_PREFERENCES);

groupStatisticsPortletPreferences.setValue(
	"displayActivityCounterName0", "user.blogs");
groupStatisticsPortletPreferences.setValue(
	"displayActivityCounterNameIndexes", "0");

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, groupStatisticsLayout.getPlid(),
	"181", groupStatisticsPortletPreferences);

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
		activityDefinition.getActivityCounterDefinition(
			activityCounterName);

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

	activityCounterDefinition.setEnabled(
		actionJSONObject.getBoolean("active"));
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

try {
	BlogsEntry blogsEntry = BlogsEntryLocalServiceUtil.getEntry(
		groupId, "blog-title");

	blogsClassNameId = PortalUtil.getClassNameId(
		"com.liferay.portlet.blogs.model.BlogsEntry");
	userClassNameId = PortalUtil.getClassNameId(
		"com.liferay.portal.model.User");

	SocialActivityCounterLocalServiceUtil.addActivityCounter(
		groupId, userClassNameId, userId, "user.blogs", 1, 1, 0, 0);
	SocialActivityCounterLocalServiceUtil.addActivityCounter(
		groupId, userClassNameId, userId, "participation", 1, 5, 0, 0);
	SocialActivityCounterLocalServiceUtil.addActivityCounter(
		groupId, userClassNameId, userId, "user.activities", 1, 1, 0, 0);
	SocialActivityCounterLocalServiceUtil.addActivityCounter(
		groupId, blogsClassNameId, blogsEntry.getEntryId(),
		"asset.activities", 2, 1, 0, 0);
}
catch (NoSuchEntryException nsee) {
}

// Requests

Layout requestsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, socialLayout.getLayoutId(), "Requests", "", "",
	"portlet", false, "/requests", serviceContext);

LayoutTypePortlet requestsLayoutTypePortlet =
	(LayoutTypePortlet)requestsLayout.getLayoutType();

requestsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SocialSM0003", "column-1", -1, false);
requestsLayoutTypePortlet.addPortletId(userId, "121", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, requestsLayout.getLayoutId(),
	requestsLayout.getTypeSettings());

// User Statistics

Layout userStatisticsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, socialLayout.getLayoutId(), "User Statistics", "",
	"", "portlet", false, "/user-statistics", serviceContext);

LayoutTypePortlet userStatisticsLayoutTypePortlet =
	(LayoutTypePortlet)userStatisticsLayout.getLayoutType();

userStatisticsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SocialSM0004", "column-1", -1, false);
userStatisticsLayoutTypePortlet.addPortletId(
	userId, "180", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, userStatisticsLayout.getLayoutId(),
	userStatisticsLayout.getTypeSettings());

PortletPreferences userStatisticsPortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		userStatisticsLayout.getPlid(), "180",
		PortletConstants.DEFAULT_PREFERENCES);

userStatisticsPortletPreferences.setValue(
	"rankByContribution", "true");
userStatisticsPortletPreferences.setValue(
	"rankByParticipation", "true");
userStatisticsPortletPreferences.setValue(
	"displayActivityCounterName0", "user.blogs");

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, userStatisticsLayout.getPlid(),
	"180", userStatisticsPortletPreferences);

// Link parent page with first child page

UnicodeProperties socialTypeSettingsProperties =
	socialLayout.getTypeSettingsProperties();

socialTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(activitiesLayout.getLayoutId()));

socialLayout.setTypeSettingsProperties(socialTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, socialLayout.getLayoutId(), socialLayout.getTypeSettings());