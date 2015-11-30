package control;

import view.ui.ImageDisplay;

public class NextImageCommand implements Command{
    private ImageDisplay display;

    public NextImageCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {

    }
}
