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

// Add news part

Map<Locale, String> nameMapNews = new HashMap<Locale, String>();

nameMapNews.put(Locale.US, "News");

Map<Locale, String> titleMapNews = new HashMap<Locale, String>();

titleMapNews.put(Locale.US, "");

Map<Locale, String> descriptionMapNews = new HashMap<Locale, String>();

descriptionMapNews.put(Locale.US, "");

Map<Locale, String> keywordsMapNews = new HashMap<Locale, String>();

keywordsMapNews.put(Locale.US, "");

Map<Locale, String> robotsMapNews = new HashMap<Locale, String>();

robotsMapNews.put(Locale.US, "");

Map<Locale, String> friendlyURLMapNews = new HashMap<Locale, String>();

friendlyURLMapNews.put(Locale.US, "/news");

Layout layoutNews = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapNews, titleMapNews,
	descriptionMapNews, keywordsMapNews, robotsMapNews, "link_to_layout", 
	null, false, friendlyURLMapNews, serviceContext);

layoutNewsId = layoutNews.getLayoutId();

Map<Locale, String> nameMapAlerts = new HashMap<Locale, String>();

nameMapAlerts.put(Locale.US, "Alerts");

Map<Locale, String> titleMapAlerts = new HashMap<Locale, String>();

titleMapAlerts.put(Locale.US, "");

Map<Locale, String> descriptionMapAlerts = new HashMap<Locale, String>();

descriptionMapAlerts.put(Locale.US, "");

Map<Locale, String> keywordsMapAlerts = new HashMap<Locale, String>();

keywordsMapAlerts.put(Locale.US, "");

Map<Locale, String> robotsMapAlerts = new HashMap<Locale, String>();

robotsMapAlerts.put(Locale.US, "");

Map<Locale, String> friendlyURLMapAlerts = new HashMap<Locale, String>();

friendlyURLMapAlerts.put(Locale.US, "/alerts");

Layout layoutAlerts = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutNewsId, nameMapAlerts, titleMapAlerts,
	descriptionMapAlerts, keywordsMapAlerts, robotsMapAlerts, "portlet",
	null, false, friendlyURLMapAlerts, serviceContext);

Map<Locale, String> nameMapAnnouncement = new HashMap<Locale, String>();

nameMapAnnouncement.put(Locale.US, "Announcements");

Map<Locale, String> titleMapAnnouncement = new HashMap<Locale, String>();

titleMapAnnouncement.put(Locale.US, "");

Map<Locale, String> descriptionMapAnnouncement = new HashMap<Locale, String>();

descriptionMapAnnouncement.put(Locale.US, "");

Map<Locale, String> keywordsMapAnnouncement = new HashMap<Locale, String>();

keywordsMapAnnouncement.put(Locale.US, "");

Map<Locale, String> robotsMapAnnouncement = new HashMap<Locale, String>();

robotsMapAnnouncement.put(Locale.US, "");

Map<Locale, String> friendlyURLMapAnnouncement = new HashMap<Locale, String>();

friendlyURLMapAnnouncement.put(Locale.US, "/announcements");

Layout layoutAnnouncement = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutNewsId, nameMapAnnouncement,
	titleMapAnnouncement, descriptionMapAnnouncement,
	keywordsMapAnnouncement, robotsMapAnnouncement, "portlet", null, false,
	friendlyURLMapAnnouncement, serviceContext);

Map<Locale, String> nameMapRSS = new HashMap<Locale, String>();

nameMapRSS.put(Locale.US, "RSS");

Map<Locale, String> titleMapRSS = new HashMap<Locale, String>();

titleMapRSS.put(Locale.US, "");

Map<Locale, String> descriptionMapRSS = new HashMap<Locale, String>();

descriptionMapRSS.put(Locale.US, "");

Map<Locale, String> keywordsMapRSS = new HashMap<Locale, String>();

keywordsMapRSS.put(Locale.US, "");

Map<Locale, String> robotsMapRSS = new HashMap<Locale, String>();

robotsMapRSS.put(Locale.US, "");

Map<Locale, String> friendlyURLMapRSS = new HashMap<Locale, String>();

friendlyURLMapRSS.put(Locale.US, "/rss");

Layout layoutRSS = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutNewsId, nameMapRSS, titleMapRSS,
	descriptionMapRSS, keywordsMapRSS, robotsMapRSS, "portlet", null,
	false, friendlyURLMapRSS, serviceContext);

// News page links to alert converter page.

UnicodeProperties typeSettingsPropertiesNews =
	layoutNews.getTypeSettingsProperties();

typeSettingsPropertiesNews.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesNews.setProperty("show-alternate-links", "true");
typeSettingsPropertiesNews.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesNews.setProperty(
	"linkToLayoutId", String.valueOf(layoutAlerts.getLayoutId()));
typeSettingsPropertiesNews.setProperty("sitemap-include", "1");
typeSettingsPropertiesNews.setProperty("layout-template-id", "2_columns_ii");

layoutNews.setTypeSettingsProperties(typeSettingsPropertiesNews);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutNewsId, layoutNews.getTypeSettings());
