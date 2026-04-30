package hw.ch12;

public class NumberedBorder extends Border {

    public NumberedBorder(Display display) {
        super(display);

    }

    @Override
    public int getColumns() {
        return display.getColumns() + 4;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        String index = String.format("%2d",row+1);
        return index+"| "+ display.getRowText(row);
    }
}
