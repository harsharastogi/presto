package com.facebook.presto.orc;

import com.facebook.presto.orc.proto.DwrfProto;

import java.util.List;
import java.util.Map;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;

public class DwrfStreamReorderingConfig
{
    // column is the logical columns index for a table with n columns
    // This index starts from 0 to n - 1
    Map<Integer, List<DwrfProto.KeyInfo>> columnIdToFlatMapKeyIds;
    public DwrfStreamReorderingConfig(Map<Integer, List<DwrfProto.KeyInfo>> columnIdToFlatMapKeyIds) {
        this.columnIdToFlatMapKeyIds = requireNonNull(columnIdToFlatMapKeyIds, "columnIdToFlatMapKeyIds cannot be null");
    }

    public Map<Integer, List<DwrfProto.KeyInfo>> getStreamReordering() {
        return columnIdToFlatMapKeyIds;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("colIdToStreamOrder", columnIdToFlatMapKeyIds.toString())
                .toString();
    }
}
