/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.devmaster.elasticsearch.script;

import org.devmaster.elasticsearch.index.mapper.Recurring;
import org.joda.time.LocalDate;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Map;

public class NextOccurrenceSearchScript extends AbstractRecurringSearchScript {

    public static final String SCRIPT_NAME = "nextOccurrence";

    private static final String PARAM_FIELD = "field";

    public NextOccurrenceSearchScript(Map<String, String> paramMap) {
        super(paramMap);
    }

    public static class Factory extends AbstractRecurringSearchScript.AbstractFactory<NextOccurrenceSearchScript> {

        public Factory() {
            super(NextOccurrenceSearchScript.class, Arrays.asList(PARAM_FIELD));
        }

    }

    @Override
    public Object run() {
        Recurring recurring = getRecurring(getParamValueFor(PARAM_FIELD));
        try {
            LocalDate nextOccurrence = recurring.getNextOccurrence();
            return nextOccurrence != null ? nextOccurrence.toString() : null;
        } catch (ParseException ignored) { }
        return null;
    }

}
