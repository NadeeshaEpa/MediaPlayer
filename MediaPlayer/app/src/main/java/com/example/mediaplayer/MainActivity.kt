package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mediaplayer.ui.theme.MediaPlayerTheme

class MainActivity : ComponentActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the MediaPlayer instance and start playing a default audio file.
        mediaPlayer = MediaPlayer.create(this, R.raw.my_audio_file)

        val playButton = findViewById<Button>(R.id.playButton)
        val pauseButton = findViewById<Button>(R.id.pauseButton)
        val stopButton = findViewById<Button>(R.id.stopButton)

        playButton.setOnClickListener {
            mediaPlayer.start()
        }

        pauseButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        stopButton.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.prepare() // Reset the MediaPlayer
        }
        }

        override fun onStart() {
            super.onStart()
            // Resume the audio playback if it was previously paused.
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }

        override fun onPause() {
            super.onPause()
            // Pause the audio playback.
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        override fun onStop() {
            super.onStop()
            // Release the MediaPlayer instance when the activity is stopped.
            mediaPlayer.release()
        }
}

