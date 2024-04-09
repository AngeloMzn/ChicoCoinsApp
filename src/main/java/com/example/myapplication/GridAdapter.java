package com.example.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mSongResources;
    private LayoutInflater mInflater;
    private MediaPlayer mMediaPlayer;
    private boolean isPlaying = false;

    public GridAdapter(Context context, List<Integer> songResources) {
        mContext = context;
        mSongResources = songResources;
        mInflater = LayoutInflater.from(context);
        mMediaPlayer = new MediaPlayer();
    }

    @Override
    public int getCount() {
        return mSongResources.size();
    }

    @Override
    public Object getItem(int position) {
        return mSongResources.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.grid_item_layout, parent, false);
            holder = new ViewHolder();
            holder.button = convertView.findViewById(R.id.btn_grid_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    pauseMusic();
                } else {
                    playMusic(position);
                }
            }
        });

        return convertView;
    }

    static class ViewHolder {
        Button button;
    }

    public void playMusic(int position) {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.reset();
        }
        try {
            mMediaPlayer = MediaPlayer.create(mContext, mSongResources.get(position));
            mMediaPlayer.start();
            isPlaying = true;
        } catch (Exception e) {
            Toast.makeText(mContext, "Erro ao reproduzir a música", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void pauseMusic() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            isPlaying = false;
        }
    }

    public void stop() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            isPlaying = false;
        }
    }

    public void resumeMusic() {
        if (!mMediaPlayer.isPlaying()) {
            mMediaPlayer.start();
            isPlaying = true;
        }
    }

    public boolean getIsPlaying(){
        return this.isPlaying;
    }
}
