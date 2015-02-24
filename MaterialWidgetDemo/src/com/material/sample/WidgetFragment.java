package com.material.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.material.widget.ActionSheet;
import com.material.widget.FloatingEditText;

/**
 * Created by IntelliJ IDEA.
 * User: keith.
 * Date: 14-9-30.
 * Time: 9:48.
 */
public class WidgetFragment extends Fragment {

    private static final String TAG = WidgetFragment.class.getSimpleName();

    private int mResourceId;

    public static WidgetFragment newInstance(int resourceId) {
        WidgetFragment widgetFragment = new WidgetFragment();
        widgetFragment.mResourceId = resourceId;
        return widgetFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(mResourceId, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (mResourceId == R.layout.widget_layout1) {
            view.findViewById(R.id.paper_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActionSheet actionSheet = new ActionSheet(getActivity());
                    //actionSheet.show();
                }
            });
        }
        if (mResourceId == R.layout.widget_layout2) {
            final FloatingEditText editText = (FloatingEditText) view.findViewById(R.id.floating_edit_text);
            view.findViewById(R.id.validate_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editText.setValidateResult(false, "Error validate result");
                }
            });
        }
    }
}
