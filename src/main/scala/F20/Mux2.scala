package F20

import chisel3._
import chisel3.util._

class Mux2 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(1.W))
    val b = Input(UInt(1.W))
    val sel = Input(UInt(1.W))
    val y = Output(UInt(1.W))
  })
  when (io.sel === 0.U) {
    io.y := io.a
  } otherwise {
    io.y := io.b
  }
}