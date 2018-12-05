package com.example.myapplication.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.AnwerInfo;

import java.util.Timer;
import java.util.TimerTask;


/**
 * ViewPager切换的View,用来显示题
 * <p>
 * Created by Mjj on 2016/12/20.
 */

public class ReadFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private AnwerInfo.DataBean.SubDataBean subDataBean;
    private View view;
    private ProgressBar mProgress;
    private TextView mTvQuestion;

    public ReadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ReadFragment.
     */
    public static ReadFragment newInstance(AnwerInfo.DataBean.SubDataBean subDataBean) {
        ReadFragment fragment = new ReadFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, subDataBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            subDataBean = (AnwerInfo.DataBean.SubDataBean) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_read, container, false);

        initView();
        return view;
    }

    private void initView() {
        mProgress = (ProgressBar) view.findViewById(R.id.progress);
        mTvQuestion = (TextView) view.findViewById(R.id.tv_question);
        mProgress.setVisibility(View.GONE);
        mTvQuestion.setText(subDataBean.getQuestionid() + ". " + subDataBean.getQuestion()
                + "\n\nA." + subDataBean.getOptiona()
                + "\nB." + subDataBean.getOptionb()
                + "\nC." + subDataBean.getOptionc()
                + "\nD." + subDataBean.getOptiond()
                + "\n\n\n答案解析：" + subDataBean.getExplain()
        );

    }

}
