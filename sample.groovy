import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;

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

// Sample

Layout sampleLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Sample", "", "", "link_to_layout", false,
	"/sample", serviceContext);

// Hello Velocity

Layout helloVelocityLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, sampleLayout.getLayoutId(), "Hello Velocity", "",
	"", "portlet", false, "/hello-velocity", serviceContext);

LayoutTypePortlet helloVelocityLayoutTypePortlet =
	(LayoutTypePortlet)helloVelocityLayout.getLayoutType();

helloVelocityLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SampleSM0001", "column-1", -1, false);
helloVelocityLayoutTypePortlet.addPortletId(
	userId, "50", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, helloVelocityLayout.getLayoutId(),
	helloVelocityLayout.getTypeSettings());

// Hello World

Layout helloWorldLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, sampleLayout.getLayoutId(), "Hello World", "", "",
	"portlet", false, "/hello-world", serviceContext);

LayoutTypePortlet helloWorldLayoutTypePortlet =
	(LayoutTypePortlet)helloWorldLayout.getLayoutType();

helloWorldLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SampleSM0002", "column-1", -1, false);
helloWorldLayoutTypePortlet.addPortletId(userId, "47", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, helloWorldLayout.getLayoutId(),
	helloWorldLayout.getTypeSettings());

// IFrame

Layout iframeLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, sampleLayout.getLayoutId(), "IFrame", "", "",
	"portlet", false, "/iframe", serviceContext);

LayoutTypePortlet iframeLayoutTypePortlet =
	(LayoutTypePortlet)iframeLayout.getLayoutType();

iframeLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SampleSM0003", "column-1", -1, false);
iframeLayoutTypePortlet.addPortletId(
	userId, "48_INSTANCE_SampleIF0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, iframeLayout.getLayoutId(), iframeLayout.getTypeSettings());

PortletPreferences iframePortletPreferences =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		iframeLayout.getPlid(), "48_INSTANCE_SampleIF0001",
		PortletConstants.DEFAULT_PREFERENCES);

iframePortletPreferences.setValue("src", "http://baidu.com");

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, iframeLayout.getPlid(),
	"48_INSTANCE_SampleIF0001", iframePortletPreferences);

// Web Proxy

Layout webProxyLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, sampleLayout.getLayoutId(), "Web Proxy", "", "",
	"portlet", false, "/web-proxy", serviceContext);

LayoutTypePortlet webProxyLayoutTypePortlet =
	(LayoutTypePortlet)webProxyLayout.getLayoutType();

webProxyLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_SampleSM0004", "column-1", -1, false);
webProxyLayoutTypePortlet.addPortletId(
	userId, "66_INSTANCE_SampleWP0001", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, webProxyLayout.getLayoutId(),
	webProxyLayout.getTypeSettings());

// Link parent page with first child page

UnicodeProperties sampleTypeSettingsProperties =
	sampleLayout.getTypeSettingsProperties();

sampleTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(helloVelocityLayout.getLayoutId()));

sampleLayout.setTypeSettingsProperties(sampleTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, sampleLayout.getLayoutId(), sampleLayout.getTypeSettings());