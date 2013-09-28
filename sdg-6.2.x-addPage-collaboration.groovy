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

// Add collaboration part

Map<Locale, String> nameMapCollaboration = new HashMap<Locale, String>();

nameMapCollaboration.put(Locale.US, "Collaboration");

Map<Locale, String> titleMapCollaboration = new HashMap<Locale, String>();

titleMapCollaboration.put(Locale.US, "");

Map<Locale, String> descriptionMapCollaboration = new HashMap<Locale, String>();

descriptionMapCollaboration.put(Locale.US, "");

Map<Locale, String> keywordsMapCollaboration = new HashMap<Locale, String>();

keywordsMapCollaboration.put(Locale.US, "");

Map<Locale, String> robotsMapCollaboration = new HashMap<Locale, String>();

robotsMapCollaboration.put(Locale.US, "");

Map<Locale, String> friendlyURLMapCollaboration = new HashMap<Locale, String>();

friendlyURLMapCollaboration.put(Locale.US, "/collaboration");

Layout collaborationLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapCollaboration, titleMapCollaboration,
	descriptionMapCollaboration, keywordsMapCollaboration,
	robotsMapCollaboration, "link_to_layout", null, false,
	friendlyURLMapCollaboration, serviceContext);

collaborationlayoutId = collaborationLayout.getLayoutId();

Map<Locale, String> nameMapBlog = new HashMap<Locale, String>();

nameMapBlog.put(Locale.US, "Blogs");

Map<Locale, String> titleMapBlog = new HashMap<Locale, String>();

titleMapBlog.put(Locale.US, "");

Map<Locale, String> descriptionMapBlog = new HashMap<Locale, String>();

descriptionMapBlog.put(Locale.US, "");

Map<Locale, String> keywordsMapBlog = new HashMap<Locale, String>();

keywordsMapBlog.put(Locale.US, "");

Map<Locale, String> robotsMapBlog = new HashMap<Locale, String>();

robotsMapBlog.put(Locale.US, "");

Map<Locale, String> friendlyURLMapBlog = new HashMap<Locale, String>();

friendlyURLMapBlog.put(Locale.US, "/blogs");

Layout layoutBlogs = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationlayoutId, nameMapBlog, titleMapBlog,
	descriptionMapBlog, keywordsMapBlog, robotsMapBlog, "portlet", null, false,
	friendlyURLMapBlog, serviceContext);

Map<Locale, String> nameMapDD = new HashMap<Locale, String>();

nameMapDD.put(Locale.US, "Dynamic Data");

Map<Locale, String> titleMapDD = new HashMap<Locale, String>();

titleMapDD.put(Locale.US, "");

Map<Locale, String> descriptionMapDD = new HashMap<Locale, String>();

descriptionMapDD.put(Locale.US, "");

Map<Locale, String> keywordsMapDD = new HashMap<Locale, String>();

keywordsMapDD.put(Locale.US, "");

Map<Locale, String> robotsMapDD = new HashMap<Locale, String>();

robotsMapDD.put(Locale.US, "");

Map<Locale, String> friendlyURLMapDD = new HashMap<Locale, String>();

friendlyURLMapDD.put(Locale.US, "/dynamic-data");

Layout layoutDD = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationlayoutId, nameMapDD, titleMapDD,
	descriptionMapDD, keywordsMapDD, robotsMapDD, "portlet", null, false,
	friendlyURLMapDD, serviceContext);

Map<Locale, String> nameMapWiki = new HashMap<Locale, String>();

nameMapWiki.put(Locale.US, "Wiki");

Map<Locale, String> titleMapWiki = new HashMap<Locale, String>();

titleMapWiki.put(Locale.US, "");

Map<Locale, String> descriptionMapWiki = new HashMap<Locale, String>();

descriptionMapWiki.put(Locale.US, "");

Map<Locale, String> keywordsMapWiki = new HashMap<Locale, String>();

keywordsMapWiki.put(Locale.US, "");

Map<Locale, String> robotsMapWiki = new HashMap<Locale, String>();

robotsMapWiki.put(Locale.US, "");

Map<Locale, String> friendlyURLMapWiki = new HashMap<Locale, String>();

friendlyURLMapWiki.put(Locale.US, "/wiki");

Layout layoutWiki = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationlayoutId, nameMapWiki, titleMapWiki,
	descriptionMapWiki, keywordsMapWiki, robotsMapWiki, "portlet",null, false,
	friendlyURLMapWiki, serviceContext);

Map<Locale, String> nameMapMB = new HashMap<Locale, String>();

nameMapMB.put(Locale.US, "Message Board");

Map<Locale, String> titleMapMB = new HashMap<Locale, String>();

titleMapMB.put(Locale.US, "");

Map<Locale, String> descriptionMapMB = new HashMap<Locale, String>();

descriptionMapMB.put(Locale.US, "");

Map<Locale, String> keywordsMapMB = new HashMap<Locale, String>();

keywordsMapMB.put(Locale.US, "");

Map<Locale, String> robotsMapMB = new HashMap<Locale, String>();

robotsMapMB.put(Locale.US, "");

Map<Locale, String> friendlyURLMapMB = new HashMap<Locale, String>();

friendlyURLMapMB.put(Locale.US, "/message-board");

Layout layoutMB = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationlayoutId, nameMapMB, titleMapMB,
	descriptionMapMB, keywordsMapMB, robotsMapMB, "portlet", null, false,
	friendlyURLMapMB, serviceContext);

// Collaboration page link to blog page.

UnicodeProperties typeSettingsPropertiesColl =
	collaborationLayout.getTypeSettingsProperties();

typeSettingsPropertiesColl.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesColl.setProperty("show-alternate-links", "true");
typeSettingsPropertiesColl.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesColl.setProperty(
	"linkToLayoutId", String.valueOf(layoutBlogs.getLayoutId()));
typeSettingsPropertiesColl.setProperty("sitemap-include", "1");
typeSettingsPropertiesColl.setProperty("layout-template-id", "2_columns_ii");

collaborationLayout.setTypeSettingsProperties(typeSettingsPropertiesColl);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, collaborationlayoutId,
	collaborationLayout.getTypeSettings());
