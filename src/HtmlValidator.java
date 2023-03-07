import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

        Stack<HtmlTag> stack = new Stack<>();

        while (!tags.isEmpty()) {
            HtmlTag currentTag = tags.remove();

            if (currentTag.isOpenTag()) {
                stack.push(currentTag);
            } else if (!currentTag.isSelfClosing()) {
                if (stack.isEmpty() || !stack.peek().matches(currentTag)) {
                    return null;
                } else {
                    stack.pop();
                }
            }

        }

        return stack;

    }

    // Esta función recibe una cola de etiquetas HTML como parámetro y devuelve una
    // pila de etiquetas HTML.
    // Si las etiquetas no son válidas, devuelve nulo.
    // La función itera sobre la cola de etiquetas y comprueba si la etiqueta actual
    // es una etiqueta de apertura.
    // Si lo es, se empuja a la pila. Si no lo es, se comprueba si es una etiqueta
    // auto-cerrada.
    // Si no lo es, se comprueba si la pila está vacía o si el elemento superior de
    // la pila coincide con la etiqueta actual.
    // Si no hay coincidencia, se devuelve nulo; en caso contrario, se saca el
    // elemento superior de la pila.

}
