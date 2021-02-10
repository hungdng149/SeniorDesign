# SeniorDesign
## Getting Started
The goal of this document is to guide you through the installation process so that you can effectively install and test against the natural language processing model effectively.
### Installing the model
- Navigate to https://github.com/swabhs/open-sesame
- The aforementioned project is built on python 3.7.9 and dynet as well as some packages from nltk
```sh
$ pip install dynet==2.0.3
$ pip install nltk==3.5
$ python -m nltk.downloader averaged_perceptron_tagger wordnet
```
### Preprocess the data for the model
0. Clone the repository.
```sh
$ git clone https://github.com/swabhs/open-sesame.git
$ cd open-sesame/
 ```

1. Create a directory for the data, `$DATA`, containing the (extracted) [FrameNet version 1.7](https://drive.google.com/open?id=1s4SDt_yDhT8qFs1MZJbeFf-XeiNPNnx7) data. This should be under `$DATA/fndata-1.7/`.

2. Second, this project uses pretrained [GloVe word embeddings](https://nlp.stanford.edu/projects/glove/) of 100 dimensions, trained on 6B tokens. [Download](http://nlp.stanford.edu/data/glove.6B.100d.zip) and extract under `$DATA/embeddings_glove/`.

3. Optionally, make alterations to the configurations in `configurations/global_config.json`, if you have decided to either use a different version of FrameNet, or different pretrained embeddings, and so on.

4. In this repository, data is formatted in a [format similar to CoNLL 2009](https://ufal.mff.cuni.cz/conll2009-st/task-description.html), but with BIO tags, for ease of reading, compared to the original XML format. See sample CoNLL formatting [here](https://github.com/swabhs/open-sesame/blob/master/sample.fn1.7.train.conll). Preprocess the data by executing:
```sh
$ python -m sesame.preprocess
```
The above script writes the train, dev and test files in the required format into the `data/neural/fn1.7/` directory.
- Next step would be training the model
### Training the model

```sh
$ python -m sesame.$MODEL --mode train --model_name $MODEL_NAME
```
### Run scripts to test the model
- Run document processing java file with the document you want to process as the argument. This will create however many new files as there are lines in the document.
- Run bash by java file. This willl go through each file and run it against the model. All the necessary commands are already in place. You only have to input the file name.
