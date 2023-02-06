package com.chuan.debug;

/**
 * @author xucy-e
 */
public class DebugTest {
    /**
     * 如果以调试模式运行，并且打两个断点：
     * <ol>
     *     <li>在 main 方法中 new 出一个 Coordinate 对象的动作之后打个断点</li>
     *     <li>同时在 Coordinate 的 toString 方法处打一个断点</li>
     * </ol>
     * 会发现 IDEA 在 new 出 Coordinate 对象后会执行 toString 方法（控制台输出了打印语句），但是 toString 方法里打的断点并不能生效，
     * 同时 IDEA 给出了一个提示：<blockquote>Skipped breakpoint at com.chuan.debug.Coordinate:27 because it happened inside debugger evaluation</blockquote>
     * 但是，如果不以调试模式运行，在不会执行 Coordinate 对象的 toString 方法，控制台不存在输出语句。
     * <p/>
     * 这说明，在调试模式下：
     * <ol>
     *     <li>当程序在某个断点处停止时，IDE 为了让用户观测到相关变量的值，会调用被观测对象的 toString 方法</li>
     *     <li>debugger 生成观测值需要一个过程，在这个过程（debugger evaluation）中牵扯到的所有断点都不能生效，因此上述 toString 方法中的断点会被跳过</li>
     * </ol>
     */
    public static void main(String[] args) {
        // Skipped breakpoint at com.chuan.debug.Coordinate:27 because it happened inside debugger evaluation
        Coordinate coordinate = new Coordinate();
        coordinate.setCordX(3.);
        coordinate.setCordY(4.);
    }
}
