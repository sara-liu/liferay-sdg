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

// Add shopping part

Map<Locale, String> nameMapShopping = new HashMap<Locale, String>();

nameMapShopping.put(Locale.US, "Shopping");

Map<Locale, String> titleMapShopping = new HashMap<Locale, String>();

titleMapShopping.put(Locale.US, "");

Map<Locale, String> descriptionMapShopping = new HashMap<Locale, String>();

descriptionMapShopping.put(Locale.US, "");

Map<Locale, String> keywordsMapShopping = new HashMap<Locale, String>();

keywordsMapShopping.put(Locale.US, "");

Map<Locale, String> robotsMapShopping = new HashMap<Locale, String>();

robotsMapShopping.put(Locale.US, "");

Map<Locale, String> friendlyURLMapShopping = new HashMap<Locale, String>();

friendlyURLMapShopping.put(Locale.US, "/shopping");

Layout layoutShopping = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapShopping, titleMapShopping,
	descriptionMapShopping, keywordsMapShopping, robotsMapShopping,
	"link_to_layout", null, false, friendlyURLMapShopping, serviceContext);

layoutShoppingId = layoutShopping.getLayoutId();

Map<Locale, String> nameMapAmazonR = new HashMap<Locale, String>();

nameMapAmazonR.put(Locale.US, "Amazon Rankings");

Map<Locale, String> titleMapAmazonR = new HashMap<Locale, String>();

titleMapAmazonR.put(Locale.US, "");

Map<Locale, String> descriptionMapAmazonR = new HashMap<Locale, String>();

descriptionMapAmazonR.put(Locale.US, "");

Map<Locale, String> keywordsMapAmazonR = new HashMap<Locale, String>();

keywordsMapAmazonR.put(Locale.US, "");

Map<Locale, String> robotsMapAmazonR = new HashMap<Locale, String>();

robotsMapAmazonR.put(Locale.US, "");

Map<Locale, String> friendlyURLMapAmazonR = new HashMap<Locale, String>();

friendlyURLMapAmazonR.put(Locale.US, "/amazon-rankings");

Layout layoutAmazonR = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutShoppingId, nameMapAmazonR,
	titleMapAmazonR, descriptionMapAmazonR, keywordsMapAmazonR,
	robotsMapAmazonR, "portlet", null, false, friendlyURLMapAmazonR,
	serviceContext);

Map<Locale, String> nameMapShoppingP = new HashMap<Locale, String>();

nameMapShoppingP.put(Locale.US, "Shopping Portlet");

Map<Locale, String> titleMapShoppingP = new HashMap<Locale, String>();

titleMapShoppingP.put(Locale.US, "");

Map<Locale, String> descriptionMapShoppingP = new HashMap<Locale, String>();

descriptionMapShoppingP.put(Locale.US, "");

Map<Locale, String> keywordsMapShoppingP = new HashMap<Locale, String>();

keywordsMapShoppingP.put(Locale.US, "");

Map<Locale, String> robotsMapShoppingP = new HashMap<Locale, String>();

robotsMapShoppingP.put(Locale.US, "");

Map<Locale, String> friendlyURLMapShoppingP = new HashMap<Locale, String>();

friendlyURLMapShoppingP.put(Locale.US, "/shopping-portlet");

Layout layoutShoppingP = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutShoppingId, nameMapShoppingP,
	titleMapShoppingP, descriptionMapShoppingP, keywordsMapShoppingP,
	robotsMapShoppingP, "portlet", null, false, friendlyURLMapShoppingP,
	serviceContext);

// Shopping page links to amazon rankings page.

UnicodeProperties typeSettingsPropertiesShopping =
	layoutShopping.getTypeSettingsProperties();

typeSettingsPropertiesShopping.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesShopping.setProperty("show-alternate-links", "true");
typeSettingsPropertiesShopping.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesShopping.setProperty(
	"linkToLayoutId", String.valueOf(layoutAmazonR.getLayoutId()));
typeSettingsPropertiesShopping.setProperty("sitemap-include", "1");
typeSettingsPropertiesShopping.setProperty(
	"layout-template-id", "2_columns_ii");

layoutShopping.setTypeSettingsProperties(typeSettingsPropertiesShopping);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutShoppingId, layoutShopping.getTypeSettings());
