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
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

// Collaboration

Layout collaborationLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, "Collaboration", "", "", "link_to_layout", false,
	"/collaboration", serviceContext);

// Blogs

Layout blogsLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "Blogs", "", "",
	"portlet", false, "/blogs", serviceContext);

LayoutTypePortlet blogsLayoutTypePortlet =
	(LayoutTypePortlet)blogsLayout.getLayoutType();

blogsLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0001", "column-1", -1, false);
blogsLayoutTypePortlet.addPortletId(userId, "33", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, blogsLayout.getLayoutId(), blogsLayout.getTypeSettings());

BlogsEntryLocalServiceUtil.addEntry(
	userId, "Blog Title", "Blog description",
	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
		"eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	0, 1, 2010, 12, 0, true, false, new String[0], false, "", "", null,
	serviceContext);

// Blogs Aggregator

Layout blogsAggregatorLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(),
	"Blogs Aggregator", "", "", "portlet", false, "/blogs-aggregator",
	serviceContext);

LayoutTypePortlet blogsAggregatorLayoutTypePortlet =
	(LayoutTypePortlet)blogsAggregatorLayout.getLayoutType();

blogsAggregatorLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0002", "column-1", -1, false);
blogsAggregatorLayoutTypePortlet.addPortletId(
	userId, "115", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, blogsAggregatorLayout.getLayoutId(),
	blogsAggregatorLayout.getTypeSettings());

// Dynamic Data List Display 

Layout ddlDisplayLayout1 = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "DDL Display 1",
	"", "", "portlet", false, "/ddl-display-1", serviceContext);

LayoutTypePortlet ddlDisplayLayoutTypePortlet1 =
	(LayoutTypePortlet)ddlDisplayLayout1.getLayoutType();

ddlDisplayLayoutTypePortlet1.addPortletId(
	userId, "85_INSTANCE_CollabSM0003", "column-1", -1, false);
ddlDisplayLayoutTypePortlet1.addPortletId(
	userId, "169_INSTANCE_CollabDDLD01", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, ddlDisplayLayout1.getLayoutId(),
	ddlDisplayLayout1.getTypeSettings());

classNameId = PortalUtil.getClassNameId(
	"com.liferay.portlet.dynamicdatalists.model.DDLRecordSet");

DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getStructure(
	groupId, classNameId, "CONTACTS");

Map<Locale, String> ddmRecordSetNameMap = new HashMap<Locale, String>();

ddmRecordSetNameMap.put(Locale.US, "DDL Record Set Name");

Map<Locale, String> ddmRecordSetDescriptionMap = new HashMap<Locale, String>();

ddmRecordSetDescriptionMap.put(Locale.US, "DDL record set description");

DDLRecordSet ddlRecordSet = DDLRecordSetLocalServiceUtil.addRecordSet(
	userId, groupId, ddmStructure.getStructureId(), null, ddmRecordSetNameMap,
	ddmRecordSetDescriptionMap, 10, 0, serviceContext);

PortletPreferences ddlDisplayPortletPreferences1 =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		ddlDisplayLayout1.getPlid(), "169_INSTANCE_CollabDDLD01",
		PortletConstants.DEFAULT_PREFERENCES);

ddlDisplayPortletPreferences1.setValue(
	"recordSetId", String.valueOf(ddlRecordSet.getRecordSetId()));

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, ddlDisplayLayout1.getPlid(), "169_INSTANCE_CollabDDLD01",
	ddlDisplayPortletPreferences1);

// Dynamic Data List Display (Spreadsheet View)

Layout ddlDisplayLayout2 = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "DDL Display 2",
	"", "", "portlet", false, "/ddl-display-2", serviceContext);

LayoutTypePortlet ddlDisplayLayoutTypePortlet2 =
	(LayoutTypePortlet)ddlDisplayLayout2.getLayoutType();

ddlDisplayLayoutTypePortlet2.addPortletId(
	userId, "85_INSTANCE_CollabSM0004", "column-1", -1, false);
ddlDisplayLayoutTypePortlet2.addPortletId(
	userId, "169_INSTANCE_CollabDDLD02", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, ddlDisplayLayout2.getLayoutId(),
	ddlDisplayLayout2.getTypeSettings());

PortletPreferences ddlDisplayPortletPreferences2 =
	PortletPreferencesLocalServiceUtil.getPreferences(
		companyId, 0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT,
		ddlDisplayLayout2.getPlid(), "169_INSTANCE_CollabDDLD02",
		PortletConstants.DEFAULT_PREFERENCES);

ddlDisplayPortletPreferences2.setValue(
	"recordSetId", String.valueOf(ddlRecordSet.getRecordSetId()));
ddlDisplayPortletPreferences2.setValue("spreadsheet", "true");

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, ddlDisplayLayout2.getPlid(), "169_INSTANCE_CollabDDLD02",
	ddlDisplayPortletPreferences2);

// Message Boards

Layout mbLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "Message Boards",
	"", "", "portlet", false, "/message-boards", serviceContext);

LayoutTypePortlet mbLayoutTypePortlet =
	(LayoutTypePortlet)mbLayout.getLayoutType();

mbLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0005", "column-1", -1, false);
mbLayoutTypePortlet.addPortletId(userId, "19", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, mbLayout.getLayoutId(), mbLayout.getTypeSettings());

MBCategory category = MBCategoryLocalServiceUtil.addCategory(
	userId, 0, "MB Category Name", "MB category description", serviceContext);

MBMessageLocalServiceUtil.addMessage(
	userId, "Test Test", groupId, category.getCategoryId(),
	"MB Message Subject",
	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
		"eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	"bbcode", new ArrayList(), false, 0.0, true, serviceContext);

// Recent Bloggers

Layout recentBloggersLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(),
	"Recent Bloggers", "", "", "portlet", false, "/recent-bloggers",
	serviceContext);

LayoutTypePortlet recentBloggersLayoutTypePortlet =
	(LayoutTypePortlet)recentBloggersLayout.getLayoutType();

recentBloggersLayoutTypePortlet.addPortletId(
	userId, "85_INSTANCE_CollabSM0006", "column-1", -1, false);
recentBloggersLayoutTypePortlet.addPortletId(
	userId, "114", "column-2", -1, false);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, recentBloggersLayout.getLayoutId(),
	recentBloggersLayout.getTypeSettings());

// Wiki

Layout wikiLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "Wiki", "", "",
	"portlet", false, "/wiki", serviceContext);

// Wiki Display

Layout wikiDisplayLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, collaborationLayout.getLayoutId(), "Wiki Display",
	"", "", "portlet", false, "/wiki-display", serviceContext);

// Link parent page with first child page

UnicodeProperties collaborationTypeSettingsProperties =
	collaborationLayout.getTypeSettingsProperties();

collaborationTypeSettingsProperties.setProperty(
	"linkToLayoutId", String.valueOf(blogsLayout.getLayoutId()));

collaborationLayout.setTypeSettingsProperties(
	collaborationTypeSettingsProperties);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, collaborationLayout.getLayoutId(),
	collaborationLayout.getTypeSettings());