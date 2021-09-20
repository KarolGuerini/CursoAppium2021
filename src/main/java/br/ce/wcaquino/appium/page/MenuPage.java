package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarFormulario(){
        clicarPorTexto("Formulário");
    }

    public void acessarSplash() {
        clicarPorTexto("Splash");
    }

    public void acessarAlerta() {
        clicarPorTexto("Alertas");
    }

    public void acessarTabs() {

        clicarPorTexto("Abas");
    }

    public void acessarAccordion() {
        clicarPorTexto("Accordion");
    }

    public void acessarCliques() {

        clicarPorTexto("Cliques");
    }

    public void acessarOpcaoEscondida() {

        clicarPorTexto("Opção bem escondida");
    }


    public void acessarSwipe(){
        clicarPorTexto("Swipe");
    }

    public void acessarSwipeList(){

        clicarPorTexto("Swipe List");
    }

    public void acessarDragAndDrop(){

        clicarPorTexto("Drag and drop");
    }

    public void acessarSeuBarrigaHibrido(){

        clicarPorTexto("SeuBarriga Nativo");
    }






}
