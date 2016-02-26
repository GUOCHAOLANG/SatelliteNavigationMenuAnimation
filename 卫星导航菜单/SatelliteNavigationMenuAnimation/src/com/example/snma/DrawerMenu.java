package com.example.snma;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

public class DrawerMenu extends ViewGroup {

	private boolean isopen = false;

	// 定义接口
	public interface OnMenuItemGClickListener {
		void onClick(View view, int pos);
	}

	private OnMenuItemGClickListener onMenuItemGClickListener;

	public DrawerMenu(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	public DrawerMenu(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public DrawerMenu(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int count = getChildCount();
		for (int i = 0; i < count; i++) {
			measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
			// getChildAt(i).measure(MeasureSpec.UNSPECIFIED,
			// MeasureSpec.UNSPECIFIED);
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		if (changed) {
			// layoutButton();
			View cButton = getChildAt(getChildCount()-1);
			// cButton.setOnClickListener(this);
			int ll = 0;
			int lt = 0;

			int width = cButton.getMeasuredWidth();
			int height = cButton.getMeasuredHeight();
			ll = getMeasuredWidth() / 2 - width;
			lt = getMeasuredHeight() / 2 - height;

			cButton.layout(ll, lt, ll + width, lt + height);
			cButton.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					// one();
					two();
				}
			});
			//
			int rrr = 200;
			int count = getChildCount();
			for (int i = 0; i < count - 1; i++) {
				final View child = getChildAt(i);
				child.setVisibility(View.GONE);
				int cl = (int) (ll + rrr
						* (Math.cos((i) * (2 * Math.PI) / (count - 1))));
				int ct = (int) (lt + rrr
						* (Math.sin((i) * (2 * Math.PI) / (count - 1))));
				int cWidth = child.getMeasuredWidth();
				int cHeight = child.getMeasuredHeight();
				// ct = getMeasuredHeight() - height * (count - i);
				// getMeasuredHeight()获取整个View的高度
				child.layout(cl, ct, cl + cWidth, ct + cHeight);
				final int abc = i;
				// 正常使用
				child.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub

						Toast.makeText(getContext(), "item=" + abc,
								Toast.LENGTH_LONG).show();
					}
				});
				// 使用接口回调
				// final int pos = i;
				// child.setOnClickListener( new OnClickListener() {
				//
				// public void onClick(View v) {
				// // TODO Auto-generated method stub
				// if(onMenuItemGClickListener != null){
				// onMenuItemGClickListener.onClick(child, pos);
				// }
				// }
				// });
			}
		}
	}

	private void two() {
		// TODO Auto-generated method stub
		int count = getChildCount();
		for (int i = 0; i < count - 1; i++) {
			View child = getChildAt(i + 0);

			int rrr = 200;
			int cl = (int) (rrr * (Math.cos((i) * (2 * Math.PI) / (count - 1))));
			int ct = (int) (rrr * (Math.sin((i) * (2 * Math.PI) / (count - 1))));
			if (isopen) {
				// TranslateAnimation ta = new TranslateAnimation(0,
				// -child.getMeasuredWidth(), 0, 0);
				TranslateAnimation ta = new TranslateAnimation(0, -cl, 0, -ct);
				ta.setDuration(1000 + i * 100);
				child.startAnimation(ta);
				child.setVisibility(View.GONE);
			} else {
				// TranslateAnimation ta = new TranslateAnimation(
				// -child.getMeasuredWidth(), 0, 0, 0);
				TranslateAnimation ta = new TranslateAnimation(-cl, 0, -ct, 0);
				ta.setDuration(1000 + i * 100);
				child.startAnimation(ta);
				child.setVisibility(View.VISIBLE);
			}
		}
		isopen = isopen == false ? true : false;
	}

	private void one() {
		// TODO Auto-generated method stub
		int count = getChildCount();
		for (int i = 0; i < count - 1; i++) {
			View child = getChildAt(i + 1);

			if (isopen) {
				TranslateAnimation ta = new TranslateAnimation(0,
						-child.getMeasuredWidth(), 0, 0);
				ta.setDuration(1000 + i * 100);
				child.startAnimation(ta);
				child.setVisibility(View.GONE);
			} else {
				TranslateAnimation ta = new TranslateAnimation(
						-child.getMeasuredWidth(), 0, 0, 0);
				ta.setDuration(1000 + i * 100);
				child.startAnimation(ta);
				child.setVisibility(View.VISIBLE);
			}
		}
		isopen = isopen == false ? true : false;
	}

	// 接口回调函数
	public void setOnMenuItemGClickListener(
			OnMenuItemGClickListener onMenuItemClickListener) {
		this.onMenuItemGClickListener = onMenuItemClickListener;
	}
}
