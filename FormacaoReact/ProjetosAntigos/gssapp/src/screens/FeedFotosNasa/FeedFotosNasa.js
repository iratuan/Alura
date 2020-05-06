import React, {Component} from 'react';

import {
  View,
  Text,
  Image,
  FlatList,
  ImageBackground,
  TextInput,
} from 'react-native';

import TopMenu from '../../components/TopMenu/TopMenu';

import styles from '../../assets/styles/styles';


class FeedFotosNasa extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      error: null,
    };
  }

  componentDidMount() {
    this.fetchData('Hover');
  }

  fetchData = word => {
    const url = 'https://images-api.nasa.gov/search?q=' + word;
    this.setState({loading: true});
    fetch(url)
      .then(res => res.json())
      .then(result => {
        if (result.collection.items.length > 0) {
          let data = [];

          result.collection.items.forEach(item => {
            let itemData = item.data.shift();
            if (itemData != null) {
              let info = {
                title: itemData.title,
                image: item.links.shift().href,
                description: itemData.description,
                date: itemData.date_created,
                center: itemData.center,
              };
              data.push(info);
            }
          });

          this.setState({
            data: data,
            error: result.error || null,
          });
        }
      })
      .catch(error => {
        this.setState({error});
      });
  };

  handleSearch = word => {
    word.length > 0 ? this.fetchData(word) : this.fetchData('hover');
  };

  renderHeader = () => {
    return (
      <View style={{flexDirection: 'row', marginBottom: 20}}>
        <TextInput
          placeholder="Search"
          lightTheme
          round
          onChangeText={text => this.handleSearch(text)}
          autoCorrect={false}
          style={styles.searchField}
        />
      </View>
    );
  };

  renderEmptyList = () => {
    return (
      <View>
        <Text>None result.</Text>
      </View>
    );
  };

  render() {
    return (
      <View style={styles.mainContainer}>
        <View>
          <TopMenu />
        </View>
        <FlatList
          data={this.state.data}
          renderItem={({item}) => (
            <View style={styles.photoContainer}>
              <View style={styles.headerContainer}>
                <Image
                  source={require('../../assets/images/nasa-logo.png')}
                  style={styles.userImage}
                />
                <Text style={{marginLeft: 10}}>{item.title}</Text>
              </View>
              <ImageBackground
                style={styles.image}
                source={require('../../assets/images/placeholder.png')}>
                <Image source={{uri: item.image}} style={styles.image} />
              </ImageBackground>
              <Text style={styles.description}>{item.description}</Text>
              <View>
                <Text style={styles.metaInfo}>
                  Date: {item.date}. Center: {item.center}
                </Text>
              </View>
            </View>
          )}
          keyExtractor={(item, index) => index.toString()}
          ListHeaderComponent={this.renderHeader}
          ListEmptyComponent={this.renderEmptyList}
        />
      </View>
    );
  }
}

export default FeedFotosNasa;
