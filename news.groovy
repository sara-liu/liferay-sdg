import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil;

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

// News

Layout newsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "News", "", "", "link_to_layout", false, "/news",
	serviceContext);

// Alerts

Layout alertsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, newsLayout.getLayoutId(), "Alerts", "", "",
	"portlet", false, "/alerts", serviceContext);

LayoutTypePortlet alertsLayoutTypePortlet =
	(LayoutTypePortlet)alertsLayout.getLayoutType();

alertsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_NewsSM000001", "column-1", -1, false);
alertsLayoutTypePortlet.addPortletId(userId, "83", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, alertsLayout.getLayoutId(), alertsLayout.getTypeSettings());

long announcementsClassNameId = PortalUtil.getClassNameId(
	"com.liferay.portal.model.Group");

AnnouncementsEntryLocalServiceUtil.addEntry(
	userId, announcementsClassNameId, groupId, "Alerts Title", "Alerts content",
	"http://www.example.com", "general", 0, 0, 0, 0, 0, true, 0, 1, 2015, 12, 0,
	0, true);

// Announcements

Layout announcementsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, newsLayout.getLayoutId(), "Announcements", "", "",
	"portlet", false, "/announcements", serviceContext);

LayoutTypePortlet announcementsLayoutTypePortlet =
	(LayoutTypePortlet)announcementsLayout.getLayoutType();

announcementsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_NewsSM000002", "column-1", -1, false);
announcementsLayoutTypePortlet.addPortletId(
	userId, "84", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, announcementsLayout.getLayoutId(),
	announcementsLayout.getTypeSettings());

AnnouncementsEntryLocalServiceUtil.addEntry(
	userId, announcementsClassNameId, groupId, "Announcements Title",
	"Announcements content", "http://www.example.com", "general", 0, 0, 0, 0, 0,
	true, 0, 1, 2015, 12, 0, 0, false);

// RSS

Layout rssLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, newsLayout.getLayoutId(), "RSS", "", "", "portlet",
	false, "/rss", serviceContext);

LayoutTypePortlet rssLayoutTypePortlet =
	(LayoutTypePortlet)rssLayout.getLayoutType();

rssLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_NewsSM000003", "column-1", -1, false);
rssLayoutTypePortlet.addPortletId(
	userId, "39_INSTANCE_NewsRSS00001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, rssLayout.getLayoutId(), rssLayout.getTypeSettings());

PortletPreferences rssPortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, rssLayout.getPlid(),
		"39_INSTANCE_NewsRSS00001", PortletConstants.DEFAULT_PREFERENCES);

def urls =
	["http://www.liferay.com/community/blogs/-/blogs_stream/community/rss",
	"http://rss.news.yahoo.com/rss/tech", 
	"http://partners.userland.com/nytRss/technology.xml"] as String[];

rssPortletPreferences.setValues(
	"urls", urls);

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, rssLayout.getPlid(),
	"39_INSTANCE_NewsRSS00001", rssPortletPreferences);

// Link parent page with first child page

UnicodeProperties newsTypeSettingsProperties =
	newsLayout.getTypeSettingsProperties();

newsTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(alertsLayout.getLayoutId()));

newsLayout.setTypeSettingsProperties(newsTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, newsLayout.getLayoutId(), newsLayout.getTypeSettings());