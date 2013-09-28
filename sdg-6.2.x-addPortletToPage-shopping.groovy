import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.PortletPreferences;

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

// Amazon rankings page

Layout layoutAmazonR = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/amazon-rankings");

UnicodeProperties typeSettingsPropertiesAmazonR =
	layoutAmazonR.getTypeSettingsProperties();

typeSettingsPropertiesAmazonR.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesAmazonR.setProperty("column-2", "67");
typeSettingsPropertiesAmazonR.setProperty(
	"column-1", "71_INSTANCE_uixmz2y3dFa6,");

layoutAmazonR.setTypeSettingsProperties(typeSettingsPropertiesAmazonR);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutAmazonR.getLayoutId(),
	layoutAmazonR.getTypeSettings());

UnicodeProperties propertiesAmazonR = new UnicodeProperties();

propertiesAmazonR.setProperty("displayStyle", "from-level-0");
propertiesAmazonR.setProperty("headerType", "root-layout");
propertiesAmazonR.setProperty("bulletStyle", "dots");
propertiesAmazonR.setProperty("rootLayoutType", "absolute");
propertiesAmazonR.setProperty("includedLayouts", "auto");
propertiesAmazonR.setProperty("nestedChildren", "1");
propertiesAmazonR.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceAmazonR", "71_INSTANCE_uixmz2y3dFa6");

portletResourceAmazonR = (String)actionRequest.getAttribute(
	"portletResourceAmazonR");

PortletPreferences portletPreferencesAmazonR =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceAmazonR);

for (Map.Entry<String, String> entry : propertiesAmazonR.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesAmazonR.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutAmazonR.getPlid(), "71_INSTANCE_uixmz2y3dFa6",
	portletPreferencesAmazonR);

// Shopping portlet page

Layout layoutShoppingP = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/shopping-portlet");

UnicodeProperties typeSettingsPropertiesShoppingP =
	layoutShoppingP.getTypeSettingsProperties();

typeSettingsPropertiesShoppingP.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesShoppingP.setProperty("column-2", "34");
typeSettingsPropertiesShoppingP.setProperty(
	"column-1", "71_INSTANCE_uixmz6y3dFa6,");

layoutShoppingP.setTypeSettingsProperties(typeSettingsPropertiesShoppingP);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutShoppingP.getLayoutId(),
	layoutShoppingP.getTypeSettings());

UnicodeProperties propertiesShoppingP = new UnicodeProperties();

propertiesShoppingP.setProperty("displayStyle", "from-level-0");
propertiesShoppingP.setProperty("headerType", "root-layout");
propertiesShoppingP.setProperty("bulletStyle", "dots");
propertiesShoppingP.setProperty("rootLayoutType", "absolute");
propertiesShoppingP.setProperty("includedLayouts", "auto");
propertiesShoppingP.setProperty("nestedChildren", "1");
propertiesShoppingP.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceShoppingP", "71_INSTANCE_uixmz6y3dFa6");

portletResourceShoppingP = (String)actionRequest.getAttribute(
	"portletResourceShoppingP");

PortletPreferences portletPreferencesShoppingP =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceShoppingP);

for (Map.Entry<String, String> entry : propertiesShoppingP.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesShoppingP.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutShoppingP.getPlid(), "71_INSTANCE_uixmz6y3dFa6",
	portletPreferencesShoppingP);
