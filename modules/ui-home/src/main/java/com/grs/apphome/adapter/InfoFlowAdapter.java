package com.grs.apphome.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.commlibs.base.adapter.RecyclerAdapter;
import com.commlibs.base.image.GlideUtil;
import com.grs.apphome.R;
import com.grs.home.bean.NewContent;

/**
 * <p class="note">File Note</p>
 * Created by qibin on 2017/11/8.
 */

public class InfoFlowAdapter extends RecyclerAdapter<NewContent.ResultsBean> {

    public InfoFlowAdapter() {
        super(R.layout.info_flow_item);
    }

    @Override
    public void onBind(CommHolder holder, int position, int viewType, NewContent.ResultsBean data) {
        ImageView iconImageView = holder.getView(R.id.image);
        TextView titleTextView = holder.getView(R.id.title);

        String imageUrl = "";
        if (data.getResourceUrl() != null && !data.getResourceUrl().isEmpty()) {
            imageUrl = data.getResourceUrl().get(0);
        }
        GlideUtil.display(iconImageView.getContext(), iconImageView, imageUrl);
        titleTextView.setText(data.getTitle());
    }
}
