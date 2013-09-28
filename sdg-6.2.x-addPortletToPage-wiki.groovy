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

// Wiki dispaly page

Layout layoutWikiD = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/wiki-dispaly");

UnicodeProperties typeSettingsPropertiesWikiD =
	layoutWikiD.getTypeSettingsProperties();

typeSettingsPropertiesWikiD.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesWikiD.setProperty(
	"column-2", "54_INSTANCE_p6Z9AOc8mPgb,36");
typeSettingsPropertiesWikiD.setProperty(
	"column-1", "71_INSTANCE_7RY8M8EY5eT3,");

layoutWikiD.setTypeSettingsProperties(typeSettingsPropertiesWikiD);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutWikiD.getLayoutId(),
	layoutWikiD.getTypeSettings());

UnicodeProperties propertiesWikiD = new UnicodeProperties();

propertiesWikiD.setProperty("displayStyle", "from-level-0");
propertiesWikiD.setProperty("headerType", "root-layout");
propertiesWikiD.setProperty("bulletStyle", "dots");
propertiesWikiD.setProperty("rootLayoutType", "absolute");
propertiesWikiD.setProperty("includedLayouts", "auto");
propertiesWikiD.setProperty("nestedChildren", "1");
propertiesWikiD.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceWikiD", "71_INSTANCE_7RY8M8EY5eT3");

portletResourceWikiD = (String)actionRequest.getAttribute(
	"portletResourceWikiD");

PortletPreferences portletPreferencesWikiD =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceWikiD);

for (Map.Entry<String, String> entry : propertiesWikiD.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesWikiD.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutWikiD.getPlid(), "71_INSTANCE_7RY8M8EY5eT3",
	portletPreferencesWikiD);
