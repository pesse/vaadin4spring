package org.vaadin.spring.stuff.commoncomponents.config;

import com.vaadin.ui.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * TODO Document me!
 *
 * @author petter@vaadin.com
 */
@Configuration
public class CommonComponentsConfiguration {

    @Bean
    @Scope("prototype")
    Label label() {
        return new Label();
    }

    @Bean
    @Scope("prototype")
    TextField textField() {
        return new TextField();
    }

    @Bean
    @Scope("prototype")
    TextArea textArea() {
        return new TextArea();
    }

    @Bean
    @Scope("prototype")
    PasswordField passwordField() {
        return new PasswordField();
    }

    @Bean
    @Scope("prototype")
    RichTextArea richTextArea() {
        return new RichTextArea();
    }

    @Bean
    @Scope("prototype")
    DateField dateField() {
        return new DateField();
    }

    @Bean
    @Scope("prototype")
    InlineDateField inlineDateField() {
        return new InlineDateField();
    }

    @Bean
    @Scope("prototype")
    Button button() {
        return new Button();
    }

    @Bean
    @Scope("prototype")
    NativeButton nativeButton() {
        return new NativeButton();
    }

    @Bean
    @Scope("prototype")
    Link link() {
        return new Link();
    }

    @Bean
    @Scope("prototype")
    CheckBox checkBox() {
        return new CheckBox();
    }

    @Bean
    @Scope("prototype")
    ComboBox comboBox() {
        return new ComboBox();
    }

    @Bean
    @Scope("prototype")
    NativeSelect nativeSelect() {
        return new NativeSelect();
    }

    @Bean
    @Scope("prototype")
    ListSelect listSelect() {
        return new ListSelect();
    }

    @Bean
    @Scope("prototype")
    TwinColSelect twinColSelect() {
        return new TwinColSelect();
    }

    @Bean
    @Scope("prototype")
    OptionGroup optionGroup() {
        return new OptionGroup();
    }

    @Bean
    @Scope("prototype")
    Table table() {
        return new Table();
    }

    @Bean
    @Scope("prototype")
    Tree tree() {
        return new Tree();
    }

    @Bean
    @Scope("prototype")
    TreeTable treeTable() {
        return new TreeTable();
    }

    @Bean
    @Scope("prototype")
    Slider slider() {
        return new Slider();
    }

    @Bean
    @Scope("prototype")
    ColorPicker colorPicker() {
        return new ColorPicker();
    }

    @Bean
    @Scope("prototype")
    Upload upload() {
        return new Upload();
    }

    @Bean
    @Scope("prototype")
    ProgressBar progressBar() {
        return new ProgressBar();
    }

    @Bean
    @Scope("prototype")
    Image image() {
        return new Image();
    }

    @Bean
    @Scope("prototype")
    Audio audio() {
        return new Audio();
    }

    @Bean
    @Scope("prototype")
    Video video() {
        return new Video();
    }

    @Bean
    @Scope("prototype")
    VerticalLayout verticalLayout() {
        return new VerticalLayout();
    }

    @Bean
    @Scope("prototype")
    HorizontalLayout horizontalLayout() {
        return new HorizontalLayout();
    }

    @Bean
    @Scope("prototype")
    CssLayout cssLayout() {
        return new CssLayout();
    }

    @Bean
    @Scope("prototype")
    GridLayout gridLayout() {
        return new GridLayout();
    }

    @Bean
    @Scope("prototype")
    FormLayout formLayout() {
        return new FormLayout();
    }

    @Bean
    @Scope("prototype")
    AbsoluteLayout absoluteLayout() {
        return new AbsoluteLayout();
    }

    @Bean
    @Scope("prototype")
    Panel panel() {
        return new Panel();
    }
}
