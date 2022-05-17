/*
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
package com.facebook.presto.orc;

import com.facebook.presto.orc.proto.DwrfProto;

import java.util.List;
import java.util.Map;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;

public class DwrfStreamOrderingConfig
{
    // column is the logical columns index for a table with n columns
    // This index starts from 0 to n - 1
    private final Map<Integer, List<DwrfProto.KeyInfo>> columnIdToFlatMapKeyIds;

    public DwrfStreamOrderingConfig(Map<Integer, List<DwrfProto.KeyInfo>> columnIdToFlatMapKeyIds)
    {
        this.columnIdToFlatMapKeyIds = requireNonNull(columnIdToFlatMapKeyIds, "columnIdToFlatMapKeyIds cannot be null");
    }

    public Map<Integer, List<DwrfProto.KeyInfo>> getStreamOrdering()
    {
        return columnIdToFlatMapKeyIds;
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("colIdToStreamOrder", columnIdToFlatMapKeyIds)
                .toString();
    }
}
