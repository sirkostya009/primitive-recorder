package com.junkstudios.kotlinfx

import java.io.File
import javax.sound.sampled.*
import kotlin.system.exitProcess

class Recorder(path: String) : Thread() {

    private val file = File(path)

    private val format = AudioFormat(
        AudioFormat.Encoding.PCM_SIGNED,
        44100f,
        16,
        2,
        4,
        44100f,
        false
    )

    private val info = DataLine.Info(TargetDataLine::class.java, format)

    private val inputStream: AudioInputStream
    private val dataLine: TargetDataLine

    init {
        try {
            dataLine = AudioSystem.getLine(info) as TargetDataLine
            dataLine.open(format)
        } catch (e: LineUnavailableException) {
            println("Failed to initialize 'targetDataLine'")
            exitProcess(1)
        }

        inputStream = AudioInputStream(dataLine)
    }

    fun stopRecording() {
        dataLine.close()
        stop()
    }

    override fun run() {
        dataLine.start()
        AudioSystem.write(inputStream, AudioFileFormat.Type.WAVE, file)
    }
}