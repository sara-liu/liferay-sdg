import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;

import java.util.HashMap;
import java.util.Locale;

/**
 * @author Sara Liu
 */
userId = PortalUtil.getUserId(actionRequest);

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	Group.class.getName(), actionRequest);

// Add community part

Map<Locale, String> nameMapCommunity = new HashMap<Locale, String>();

nameMapCommunity.put(Locale.US, "Community");

Map<Locale, String> titleMapCommunity = new HashMap<Locale, String>();

titleMapCommunity.put(Locale.US, "");

Map<Locale, String> descriptionMapCommunity = new HashMap<Locale, String>();

descriptionMapCommunity.put(Locale.US, "");

Map<Locale, String> keywordsMapCommunity = new HashMap<Locale, String>();

keywordsMapCommunity.put(Locale.US, "");

Map<Locale, String> robotsMapCommunity = new HashMap<Locale, String>();

robotsMapCommunity.put(Locale.US, "");

Map<Locale, String> friendlyURLMapCommunity = new HashMap<Locale, String>();

friendlyURLMapCommunity.put(Locale.US, "/community");

Layout layoutCommunity = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapCommunity, titleMapCommunity, descriptionMapCommunity,
	keywordsMapCommunity, robotsMapCommunity, "link_to_layout", null, false,
	friendlyURLMapCommunity, serviceContext);

layoutCommunityId = layoutCommunity.getLayoutId();

Map<Locale, String> nameMapBookmark = new HashMap<Locale, String>();

nameMapBookmark.put(Locale.US, "Bookmarks");

Map<Locale, String> titleMapBookmark = new HashMap<Locale, String>();

titleMapBookmark.put(Locale.US, "");

Map<Locale, String> descriptionMapBookmark = new HashMap<Locale, String>();

descriptionMapBookmark.put(Locale.US, "");

Map<Locale, String> keywordsMapBookmark = new HashMap<Locale, String>();

keywordsMapBookmark.put(Locale.US, "");

Map<Locale, String> robotsMapBookmark = new HashMap<Locale, String>();

robotsMapBookmark.put(Locale.US, "");

Map<Locale, String> friendlyURLMapBookmark = new HashMap<Locale, String>();

friendlyURLMapBookmark.put(Locale.US, "/bookmarks");

Layout layoutBookmarks = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapBookmark, titleMapBookmark,
	descriptionMapBookmark, keywordsMapBookmark, robotsMapBookmark, "portlet", null, false,
	friendlyURLMapBookmark, serviceContext);

Map<Locale, String> nameMapFD = new HashMap<Locale, String>();

nameMapFD.put(Locale.US, "Friends Directory");

Map<Locale, String> titleMapFD = new HashMap<Locale, String>();

titleMapFD.put(Locale.US, "");

Map<Locale, String> descriptionMapFD = new HashMap<Locale, String>();

descriptionMapFD.put(Locale.US, "");

Map<Locale, String> keywordsMapFD = new HashMap<Locale, String>();

keywordsMapFD.put(Locale.US, "");

Map<Locale, String> robotsMapFD = new HashMap<Locale, String>();

robotsMapFD.put(Locale.US, "");

Map<Locale, String> friendlyURLMapFD = new HashMap<Locale, String>();

friendlyURLMapFD.put(Locale.US, "/friends-directory");

Layout layoutFD = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapFD, titleMapFD,
	descriptionMapFD, keywordsMapFD, robotsMapFD, "portlet", null, false,
	friendlyURLMapFD, serviceContext);

Map<Locale, String> nameMapInvitation = new HashMap<Locale, String>();

nameMapInvitation.put(Locale.US, "Invitation");

Map<Locale, String> titleMapInvitation = new HashMap<Locale, String>();

titleMapInvitation.put(Locale.US, "");

Map<Locale, String> descriptionMapInvitation = new HashMap<Locale, String>();

descriptionMapInvitation.put(Locale.US, "");

Map<Locale, String> keywordsMapInvitation = new HashMap<Locale, String>();

keywordsMapInvitation.put(Locale.US, "");

Map<Locale, String> robotsMapInvitation = new HashMap<Locale, String>();

robotsMapInvitation.put(Locale.US, "");

Map<Locale, String> friendlyURLMapInvitation = new HashMap<Locale, String>();

friendlyURLMapInvitation.put(Locale.US, "/invitation");

Layout layoutInvitation = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapInvitation,
	titleMapInvitation, descriptionMapInvitation, keywordsMapInvitation,
	robotsMapInvitation, "portlet", null, false, friendlyURLMapInvitation,
	serviceContext);

Map<Locale, String> nameMapMSite = new HashMap<Locale, String>();

nameMapMSite.put(Locale.US, "My Site");

Map<Locale, String> titleMapMSite = new HashMap<Locale, String>();

titleMapMSite.put(Locale.US, "");

Map<Locale, String> descriptionMapMSite = new HashMap<Locale, String>();

descriptionMapMSite.put(Locale.US, "");

Map<Locale, String> keywordsMapMSite = new HashMap<Locale, String>();

keywordsMapMSite.put(Locale.US, "");

Map<Locale, String> robotsMapMSite = new HashMap<Locale, String>();

robotsMapMSite.put(Locale.US, "");

Map<Locale, String> friendlyURLMapMSite = new HashMap<Locale, String>();

friendlyURLMapMSite.put(Locale.US, "/my-site");

Layout layoutMSite = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapMSite, titleMapMSite,
	descriptionMapMSite, keywordsMapMSite, robotsMapMSite, "portlet", null,
	false, friendlyURLMapMSite, serviceContext);

Map<Locale, String> nameMapPComment = new HashMap<Locale, String>();

nameMapPComment.put(Locale.US, "Page Comments");

Map<Locale, String> titleMapPComment = new HashMap<Locale, String>();

titleMapPComment.put(Locale.US, "");

Map<Locale, String> descriptionMapPComment = new HashMap<Locale, String>();

descriptionMapPComment.put(Locale.US, "");

Map<Locale, String> keywordsMapPComment = new HashMap<Locale, String>();

keywordsMapPComment.put(Locale.US, "");

Map<Locale, String> robotsMapPComment = new HashMap<Locale, String>();

robotsMapPComment.put(Locale.US, "");

Map<Locale, String> friendlyURLMapPComment = new HashMap<Locale, String>();

friendlyURLMapPComment.put(Locale.US, "/page-comments");

Layout layoutPComment = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapPComment,
	titleMapPComment, descriptionMapPComment, keywordsMapPComment,
	robotsMapPComment, "portlet", null, false, friendlyURLMapPComment,
	serviceContext);

Map<Locale, String> nameMapPDirectory = new HashMap<Locale, String>();

nameMapPDirectory.put(Locale.US, "Portal Directory");

Map<Locale, String> titleMapPDirectory = new HashMap<Locale, String>();

titleMapPDirectory.put(Locale.US, "");

Map<Locale, String> descriptionMapPDirectory = new HashMap<Locale, String>();

descriptionMapPDirectory.put(Locale.US, "");

Map<Locale, String> keywordsMapPDirectory = new HashMap<Locale, String>();

keywordsMapPDirectory.put(Locale.US, "");

Map<Locale, String> robotsMapPDirectory = new HashMap<Locale, String>();

robotsMapPDirectory.put(Locale.US, "");

Map<Locale, String> friendlyURLMapPDirectory = new HashMap<Locale, String>();

friendlyURLMapPDirectory.put(Locale.US, "/portal-directory");

Layout layoutPDirectory = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapPDirectory,
	titleMapPDirectory, descriptionMapPDirectory, keywordsMapPDirectory,
	robotsMapPDirectory, "portlet", null, false, friendlyURLMapPDirectory,
	serviceContext);

// Community page link to bookmarks page.

UnicodeProperties typeSettingsPropertiesCommunity =
	layoutCommunity.getTypeSettingsProperties();

typeSettingsPropertiesCommunity.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesCommunity.setProperty("show-alternate-links", "true");
typeSettingsPropertiesCommunity.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesCommunity.setProperty(
	"linkToLayoutId", String.valueOf(layoutBookmarks.getLayoutId()));
typeSettingsPropertiesCommunity.setProperty("sitemap-include", "1");
typeSettingsPropertiesCommunity.setProperty("layout-template-id", "2_columns_ii");

layoutCommunity.setTypeSettingsProperties(typeSettingsPropertiesCommunity);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutCommunityId,
	layoutCommunity.getTypeSettings());
