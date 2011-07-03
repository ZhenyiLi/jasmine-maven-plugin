package com.github.searls.jasmine.io.scripts;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.github.searls.jasmine.io.RelativizesFilePaths;

public class RelativizesASetOfScripts {

	private RelativizesFilePaths relativizesFilePaths = new RelativizesFilePaths();
	
	public Set<String> relativize(File from, Set<String> absoluteScripts) throws IOException {
		Set<String> relativeScripts = new LinkedHashSet<String>();
		for (String absoluteScript : absoluteScripts) {
			relativeScripts.add(relativizesFilePaths.relativize(from, new File(absoluteScript)));
		}
		return relativeScripts;
	}

}
