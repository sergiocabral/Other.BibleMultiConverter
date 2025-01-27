package biblemulticonverter.sqlite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import biblemulticonverter.ModuleRegistry;
import biblemulticonverter.format.ExportFormat;
import biblemulticonverter.format.ImportFormat;
import biblemulticonverter.format.RoundtripFormat;
import biblemulticonverter.sqlite.format.BibleAnalyzerDatabase;
import biblemulticonverter.sqlite.format.MyBibleZone;
import biblemulticonverter.sqlite.format.MyBibleZoneCrossreferences;
import biblemulticonverter.sqlite.format.MyBibleZoneDictionary;
import biblemulticonverter.sqlite.format.MySword;
import biblemulticonverter.sqlite.tools.MyBibleZoneListDownloader;
import biblemulticonverter.sqlite.tools.SQLiteDump;
import biblemulticonverter.tools.Tool;

public class SQLiteModuleRegistry extends ModuleRegistry {

	@Override
	public Collection<Module<ImportFormat>> getImportFormats() {
		return Collections.emptyList();
	}

	@Override
	public Collection<Module<ExportFormat>> getExportFormats() {
		List<Module<ExportFormat>> result = new ArrayList<Module<ExportFormat>>();
		result.add(new Module<ExportFormat>("MyBibleZoneDictionary", "MyBible.zone (Bible Reader for Android) Dictionary.", MyBibleZoneDictionary.HELP_TEXT, MyBibleZoneDictionary.class));
		result.add(new Module<ExportFormat>("MyBibleZoneCrossreferences", "MyBible.zone (Bible Reader for Android) Crossreferences.", MyBibleZoneCrossreferences.HELP_TEXT, MyBibleZoneCrossreferences.class));
		result.add(new Module<ExportFormat>("BibleAnalyzerDatabase", "Database Export format for Bible Analyzer", BibleAnalyzerDatabase.HELP_TEXT, BibleAnalyzerDatabase.class));
		return result;
	}

	@Override
	public Collection<Module<RoundtripFormat>> getRoundtripFormats() {
		List<Module<RoundtripFormat>> result = new ArrayList<Module<RoundtripFormat>>();
		result.add(new Module<RoundtripFormat>("MyBibleZone", "MyBible.zone (Bible Reader for Android).", MyBibleZone.HELP_TEXT, MyBibleZone.class));
		result.add(new Module<RoundtripFormat>("MySword", "MySword (Bible Reader for Android).", MySword.HELP_TEXT, MySword.class));
		return result;
	}

	@Override
	public Collection<Module<Tool>> getTools() {
		List<Module<Tool>> result = new ArrayList<Module<Tool>>();
		result.add(new Module<Tool>("SQLiteDump", "Dump SQLite file as a diffable text file.", SQLiteDump.HELP_TEXT, SQLiteDump.class));
		result.add(new Module<Tool>("MyBibleZoneListDownloader", "Download MyBible.Zone module list from module registry.", MyBibleZoneListDownloader.HELP_TEXT, MyBibleZoneListDownloader.class));
		return result;
	}
}
