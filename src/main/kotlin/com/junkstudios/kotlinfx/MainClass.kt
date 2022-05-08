package com.junkstudios.kotlinfx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class MainClass : Application() {
    override fun start(stage: Stage) {
        stage.scene = Scene(FXMLLoader(javaClass.getResource("recorder-view.fxml")).load())
        stage.title = "Recorder"
        stage.isResizable = false
        stage.show()
    }
}