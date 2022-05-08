package com.junkstudios.kotlinfx

import javafx.scene.control.Button

class RecorderController {

    lateinit var button: Button

    private var recording = false

    private var recorder = Recorder(Constants.path)

    private val text: String
        get() = if (recording) "Stop" else "Start"

    private val color: String
        get() = if (recording) "red" else "gray"

    fun onRecordClick() {
        recording = !recording

        button.text = text
        button.style = "-fx-background-color: $color"

        if (recording) recorder.start()
        else {
            recorder.stopRecording()
            recorder = Recorder(Constants.path)
        }
    }

}