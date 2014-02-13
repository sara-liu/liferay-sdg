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
import com.liferay.portlet.social.model.SocialActivityConstants;
import com.liferay.portlet.social.model.SocialActivityCounterConstants;
import com.liferay.portlet.social.model.SocialActivityCounterDefinition;
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

SocialActivitySettingLocalServiceUtil.updateActivitySetting(
	groupId, "com.liferay.portlet.blogs.model.BlogsEntry", true);

SocialActivitySettingLocalServiceUtil.updateActivitySetting(
	groupId, "com.liferay.portlet.wiki.model.WikiPage", true);

SocialActivitySettingLocalServiceUtil.updateActivitySetting(
	groupId, "com.liferay.portlet.messageboards.model.MBMessage", true);

List<SocialActivityCounterDefinition> createActivityCounterDefinitions() {
	List<SocialActivityCounterDefinition> definitions =
		new ArrayList<SocialActivityCounterDefinition>();

	SocialActivityCounterDefinition contributionDefinition =
		new SocialActivityCounterDefinition();

	contributionDefinition.setName(
		SocialActivityCounterConstants.NAME_CONTRIBUTION);
	contributionDefinition.setOwnerType(
		SocialActivityCounterConstants.TYPE_CREATOR);

	definitions.add(contributionDefinition);

	SocialActivityCounterDefinition participationDefinition =
		new SocialActivityCounterDefinition();

	participationDefinition.setName(
		SocialActivityCounterConstants.NAME_PARTICIPATION);
	participationDefinition.setOwnerType(
		SocialActivityCounterConstants.TYPE_ACTOR);
	participationDefinition.setLimitPeriod(0);

	definitions.add(participationDefinition);

	SocialActivityCounterDefinition popularityDefinition =
		new SocialActivityCounterDefinition();

	popularityDefinition.setName(
		SocialActivityCounterConstants.NAME_POPULARITY);
	popularityDefinition.setOwnerType(
		SocialActivityCounterConstants.TYPE_ASSET);

	definitions.add(popularityDefinition);

	return definitions;
}

SocialActivitySettingLocalServiceUtil.updateActivitySettings(
	groupId, "com.liferay.portlet.blogs.model.BlogsEntry",
	SocialActivityCounterConstants.TYPE_CREATOR,
	createActivityCounterDefinitions());

SocialActivitySettingLocalServiceUtil.updateActivitySettings(
	groupId, "com.liferay.portlet.blogs.model.BlogsEntry",
	SocialActivityConstants.TYPE_VIEW, createActivityCounterDefinitions());