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

// Add wiki part

Map<Locale, String> nameMapWikiP = new HashMap<Locale, String>();

nameMapWikiP.put(Locale.US, "Wiki Page");

Map<Locale, String> titleMapWikiP = new HashMap<Locale, String>();

titleMapWikiP.put(Locale.US, "");

Map<Locale, String> descriptionMapWikiP = new HashMap<Locale, String>();

descriptionMapWikiP.put(Locale.US, "");

Map<Locale, String> keywordsMapWikiP = new HashMap<Locale, String>();

keywordsMapWikiP.put(Locale.US, "");

Map<Locale, String> robotsMapWikiP = new HashMap<Locale, String>();

robotsMapWikiP.put(Locale.US, "");

Map<Locale, String> friendlyURLMapWikiP = new HashMap<Locale, String>();

friendlyURLMapWikiP.put(Locale.US, "/wiki-page");

Layout layoutWiki = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapWikiP, titleMapWikiP,
	descriptionMapWikiP, keywordsMapWikiP, robotsMapWikiP,
	"link_to_layout", null, false, friendlyURLMapWikiP, serviceContext);

layoutWikiId = layoutWiki.getLayoutId();

Map<Locale, String> nameMapWikiD = new HashMap<Locale, String>();

nameMapWikiD.put(Locale.US, "Wiki Display");

Map<Locale, String> titleMapWikiD = new HashMap<Locale, String>();

titleMapWikiD.put(Locale.US, "");

Map<Locale, String> descriptionMapWikiD = new HashMap<Locale, String>();

descriptionMapWikiD.put(Locale.US, "");

Map<Locale, String> keywordsMapWikiD = new HashMap<Locale, String>();

keywordsMapWikiD.put(Locale.US, "");

Map<Locale, String> robotsMapWikiD = new HashMap<Locale, String>();

robotsMapWikiD.put(Locale.US, "");

Map<Locale, String> friendlyURLMapWikiD = new HashMap<Locale, String>();

friendlyURLMapWikiD.put(Locale.US, "/wiki-dispaly");

Layout layoutWikiD = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutWikiId, nameMapWikiD, titleMapWikiD,
	descriptionMapWikiD, keywordsMapWikiD, robotsMapWikiD, "portlet", null,
	false, friendlyURLMapWikiD, serviceContext);

// Wiki page links to wiki portlet page.

UnicodeProperties typeSettingsPropertiesWikis =
	layoutWiki.getTypeSettingsProperties();

typeSettingsPropertiesWikis.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesWikis.setProperty("show-alternate-links", "true");
typeSettingsPropertiesWikis.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesWikis.setProperty(
	"linkToLayoutId", String.valueOf(layoutWikiD.getLayoutId()));
typeSettingsPropertiesWikis.setProperty("sitemap-include", "1");
typeSettingsPropertiesWikis.setProperty("layout-template-id", "2_columns_ii");

layoutWiki.setTypeSettingsProperties(typeSettingsPropertiesWikis);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutWikiId, layoutWiki.getTypeSettings());