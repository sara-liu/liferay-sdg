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
import com.liferay.portlet.social.service.SocialActivitySettingLocalServiceUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

Map<Locale, String> assetCategoryTitleMap1 = new HashMap<Locale, String>();

assetCategoryTitleMap1.put(Locale.US, "Category1");

Map<Locale, String> assetCategoryDecriptionMap1 = new HashMap<Locale, String>();

assetCategoryDecriptionMap1.put(Locale.US, "");

AssetCategoryLocalServiceUtil.addCategory(
	userId, 0, assetCategoryTitleMap1, assetCategoryDecriptionMap1,
	assetVocabulary.getVocabularyId(), null, serviceContext);

Map<Locale, String> assetCategoryTitleMap2 = new HashMap<Locale, String>();

assetCategoryTitleMap2.put(Locale.US, "Category2");

Map<Locale, String> assetCategoryDecriptionMap2 = new HashMap<Locale, String>();

assetCategoryDecriptionMap2.put(Locale.US, "");

AssetCategoryLocalServiceUtil.addCategory(
	userId, 0, assetCategoryTitleMap2, assetCategoryDecriptionMap2,
	assetVocabulary.getVocabularyId(), null, serviceContext);

// Enable social activity

SocialActivitySettingLocalServiceUtil.updateActivitySetting(
	groupId, "com.liferay.portlet.blogs.model.BlogsEntry", true);

SocialActivitySettingLocalServiceUtil.updateActivitySetting(
	groupId, "com.liferay.portlet.messageboards.model.MBMessage", true);

SocialActivitySettingLocalServiceUtil.updateActivitySetting(
	groupId, "com.liferay.portlet.wiki.model.WikiPage", true);