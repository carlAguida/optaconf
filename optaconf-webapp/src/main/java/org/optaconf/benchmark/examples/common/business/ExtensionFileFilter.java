/*
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaconf.benchmark.examples.common.business;

import java.io.File;
import java.io.FileFilter;

public class ExtensionFileFilter implements FileFilter {

    private final String extensionWithDot;

    public ExtensionFileFilter(String extension) {
        extensionWithDot = "." + extension;
    }

    public boolean accept(File file) {
        if (file.isDirectory() || file.isHidden()) {
            return false;
        }
        return file.getName().endsWith(extensionWithDot);
    }

}
