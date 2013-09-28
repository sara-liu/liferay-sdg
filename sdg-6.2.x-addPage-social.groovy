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

// Add social part

Map<Locale, String> nameMapSocial = new HashMap<Locale, String>();

nameMapSocial.put(Locale.US, "Social");

Map<Locale, String> titleMapSocial = new HashMap<Locale, String>();

titleMapSocial.put(Locale.US, "");

Map<Locale, String> descriptionMapSocial = new HashMap<Locale, String>();

descriptionMapSocial.put(Locale.US, "");

Map<Locale, String> keywordsMapSocial = new HashMap<Locale, String>();

keywordsMapSocial.put(Locale.US, "");

Map<Locale, String> robotsMapSocial = new HashMap<Locale, String>();

robotsMapSocial.put(Locale.US, "");

Map<Locale, String> friendlyURLMapSocial = new HashMap<Locale, String>();

friendlyURLMapSocial.put(Locale.US, "/social");

Layout layoutSocial = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapSocial, titleMapSocial,
	descriptionMapSocial, keywordsMapSocial, robotsMapSocial,
	"link_to_layout", null, false, friendlyURLMapSocial, serviceContext);

layoutSocialId = layoutSocial.getLayoutId();

Map<Locale, String> nameMapActivities = new HashMap<Locale, String>();

nameMapActivities.put(Locale.US, "Activities");

Map<Locale, String> titleMapActivities = new HashMap<Locale, String>();

titleMapActivities.put(Locale.US, "");

Map<Locale, String> descriptionMapActivities = new HashMap<Locale, String>();

descriptionMapActivities.put(Locale.US, "");

Map<Locale, String> keywordsMapActivities = new HashMap<Locale, String>();

keywordsMapActivities.put(Locale.US, "");

Map<Locale, String> robotsMapActivities = new HashMap<Locale, String>();

robotsMapActivities.put(Locale.US, "");

Map<Locale, String> friendlyURLMapActivities = new HashMap<Locale, String>();

friendlyURLMapActivities.put(Locale.US, "/activities");

Layout layoutActivities = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutSocialId, nameMapActivities,
	titleMapActivities, descriptionMapActivities, keywordsMapActivities,
	robotsMapActivities, "portlet", null, false, friendlyURLMapActivities,
	serviceContext);

Map<Locale, String> nameMapStatistics = new HashMap<Locale, String>();

nameMapStatistics.put(Locale.US, "Statistics");

Map<Locale, String> titleMapStatistics = new HashMap<Locale, String>();

titleMapStatistics.put(Locale.US, "");

Map<Locale, String> descriptionMapStatistics = new HashMap<Locale, String>();

descriptionMapStatistics.put(Locale.US, "");

Map<Locale, String> keywordsMapStatistics = new HashMap<Locale, String>();

keywordsMapStatistics.put(Locale.US, "");

Map<Locale, String> robotsMapStatistics = new HashMap<Locale, String>();

robotsMapStatistics.put(Locale.US, "");

Map<Locale, String> friendlyURLMapStatistics = new HashMap<Locale, String>();

friendlyURLMapStatistics.put(Locale.US, "/statistics");

Layout layoutStatistics = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutSocialId, nameMapStatistics,
	titleMapStatistics, descriptionMapStatistics, keywordsMapStatistics,
	robotsMapStatistics, "portlet", null, false, friendlyURLMapStatistics,
	serviceContext);

Map<Locale, String> nameMapRequests = new HashMap<Locale, String>();

nameMapRequests.put(Locale.US, "Requests");

Map<Locale, String> titleMapRequests = new HashMap<Locale, String>();

titleMapRequests.put(Locale.US, "");

Map<Locale, String> descriptionMapRequests = new HashMap<Locale, String>();

descriptionMapRequests.put(Locale.US, "");

Map<Locale, String> keywordsMapRequests = new HashMap<Locale, String>();

keywordsMapRequests.put(Locale.US, "");

Map<Locale, String> robotsMapRequests = new HashMap<Locale, String>();

robotsMapRequests.put(Locale.US, "");

Map<Locale, String> friendlyURLMapRequests = new HashMap<Locale, String>();

friendlyURLMapRequests.put(Locale.US, "/requests");

Layout layoutRequests = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutSocialId, nameMapRequests,
	titleMapRequests, descriptionMapRequests, keywordsMapRequests,
	robotsMapRequests, "portlet", null, false, friendlyURLMapRequests,
	serviceContext);

// Social page links to activities page.

UnicodeProperties typeSettingsPropertiesSocial =
	layoutSocial.getTypeSettingsProperties();

typeSettingsPropertiesSocial.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesSocial.setProperty("show-alternate-links", "true");
typeSettingsPropertiesSocial.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesSocial.setProperty(
	"linkToLayoutId", String.valueOf(layoutActivities.getLayoutId()));
typeSettingsPropertiesSocial.setProperty("sitemap-include", "1");
typeSettingsPropertiesSocial.setProperty("layout-template-id", "2_columns_ii");

layoutSocial.setTypeSettingsProperties(typeSettingsPropertiesSocial);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSocialId, layoutSocial.getTypeSettings());
