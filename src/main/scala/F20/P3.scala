package F20

import chisel3._
import chisel3.util._

class P3 extends Module {
  val io = IO(new Bundle {
    val din = Input(Bool())
    val dout = Output(Bool())
  })

  io.dout := !io.din && RegNext(io.din)
}

object AddMain extends App {
  println("Generating the adder hardware")
  emitVerilog(new P1(), Array("--target-dir", "generated"))
}