package com.scalawilliam.dot

import org.scalatest.FreeSpec
import org.scalatest.Matchers._

class DotToSvgSpec extends FreeSpec {
  "it renders some SVG" in {
    val svg = DotToSvg
      .fromNewScriptEngine()
      .renderDot(DotToSvg.SAMPLE_GRAPH)

    svg should include("<svg")
  }
}
