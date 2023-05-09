package F20

import chisel3._
import chisel3.util._

class P1 extends Module {
  val io = IO(new Bundle {
    val clear = Input(Bool())
    val event = Input(Bool())
    val cnt = Output(UInt(8.W))
  })

  val reg = RegInit(0.U(8.W))

  when(io.clear){
    reg := 0.U
  }.elsewhen(io.event){
    reg := reg + 1.U
  }

  io.cnt := reg
}

object AddMain extends App {
  println("Generating the adder hardware")
  emitVerilog(new P1(), Array("--target-dir", "generated"))
}