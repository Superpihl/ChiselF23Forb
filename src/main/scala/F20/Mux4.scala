package F20

import chisel3._
import chisel3.util._

class Mux4 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(1.W))
    val b = Input(UInt(1.W))
    val c = Input(UInt(1.W))
    val d = Input(UInt(1.W))
    val sel = Input(UInt(2.W))
    val y = Output(UInt(1.W))
  })

  val m1 = Module(new Mux2())
  val m2 = Module(new Mux2())
  val m3 = Module(new Mux2())

  m1.io.a := io.a
  m1.io.b := io.b
  m1.io.sel := io.sel(0)

  m2.io.a := io.c
  m2.io.b := io.d
  m2.io.sel := io.sel(0)

  m3.io.a := m1.io.y
  m3.io.b := m2.io.y
  m3.io.sel := io.sel(1)

  io.y := m3.io.y

}