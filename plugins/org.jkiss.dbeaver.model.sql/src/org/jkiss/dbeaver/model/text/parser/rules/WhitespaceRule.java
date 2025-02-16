/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.model.text.parser.rules;

import org.jkiss.dbeaver.model.text.parser.TPCharacterScanner;
import org.jkiss.dbeaver.model.text.parser.TPRule;
import org.jkiss.dbeaver.model.text.parser.TPToken;
import org.jkiss.dbeaver.model.text.parser.TPTokenAbstract;

/**
 * Whitespace rule
 */
public class WhitespaceRule implements TPRule {

    private final TPToken fWhitespaceToken;

    public WhitespaceRule(TPToken token) {
        fWhitespaceToken = token;
    }

    @Override
    public TPToken evaluate(TPCharacterScanner scanner) {
        int c = scanner.read();
        if (Character.isWhitespace((char) c)) {
            do {
                c = scanner.read();
            } while (Character.isWhitespace((char) c));
            scanner.unread();
            return fWhitespaceToken;
        }

        scanner.unread();
        return TPTokenAbstract.UNDEFINED;
    }
}
