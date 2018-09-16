/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.seagrid.desktop.ui.prestageupload;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.seagrid.desktop.ui.experiment.create.ExperimentCreateWindow;
import org.seagrid.desktop.ui.prestageupload.controller.PrestageUploadController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PrestageUploadWindow extends Application{
    private final static Logger logger = LoggerFactory.getLogger(PrestageUploadWindow.class);

    private static Stage createPrimaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/prestageupload/upload-files.fxml"));
        primaryStage.setTitle("SEAGrid Desktop Client - Prestage Upload");
        primaryStage.setScene(new Scene(root, 400, 150));
        primaryStage.show();
    }

    public static void displayUploadFiles() throws IOException {
        if(createPrimaryStage == null || !createPrimaryStage.isShowing()) {
            createPrimaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(ExperimentCreateWindow.class.getResource(
                    "/views/prestageupload/upload-files.fxml"));
            Parent root = loader.load();
            createPrimaryStage.setTitle("SEAGrid Desktop Client - Prestage Upload");
            createPrimaryStage.setScene(new Scene(root, 400, 150));
            createPrimaryStage.initModality(Modality.WINDOW_MODAL);
            createPrimaryStage.show();
        }
        createPrimaryStage.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}