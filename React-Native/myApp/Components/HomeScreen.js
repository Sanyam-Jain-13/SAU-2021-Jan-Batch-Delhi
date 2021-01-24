import React, {Component} from 'react';
import {StyleSheet, View, Text, FlatList,Image, TextInput, TouchableOpacity, ActionSheetIOS, ActivityIndicator} from 'react-native';

//----------------------------------------------------------------------------------------------------------------------


export default class App extends Component {

  constructor(){
    super();
    this.state = {
        datasource : [],
        isLoading : true,
        isSorted : false,
        temp_Data : []
        //isVisible : true
    };
    this.textinput = React.createRef();
    
  }

  //----------------------------------------------------------------------------------------------------------------------

  //Flatlist items : (Image, Books Title, Page Count , Description)
  renderItem = ({item}) => {
    return(
    <View style={{flex:1,flexDirection : "column"}}>  
      <Image style={{height:500,width:"100%"}} //resizeMode:'contain', flex:1, aspectRatio:1
       source = {{uri : item.thumbnailUrl}}
       />
       <View style={styles.TextBoxDescriptions}>
           <Text style={{fontSize:20, fontWeight:"bold",marginVertical:"3%"} }>{item.title}</Text>
          <Text style={{fontSize:20,fontWeight:"bold",marginVertical:"3%"}}>{item.pageCount}</Text>
       </View>

       <TouchableOpacity style={styles.ViewButton}
       onPress={()=> this.props.navigation.navigate('Details', {
         itemTitle : item.title,itemImage : item.thumbnailUrl})
        }>
          <Text style={{textAlign:"center",fontSize:20,fontWeight:"bold"}}>View Details</Text>
        </TouchableOpacity>

        <TextInput style={styles.Description}
        multiline={true}
        numberOfLines={8}
        value={item.shortDescription ? item.shortDescription : 'No Description'}
        />
    </View>
    );
  };

  //----------------------------------------------------------------------------------------------------------------------

  //FLatlist Header : Includes (Search box, Clear field button, Sort on basis of page Count)
  header = () =>{
    return(
      <View style={{flex:1,flexDirection:"row",justifyContent:"space-around",marginVertical:40,flexWrap:"wrap",
      backgroundColor:"rgba(255,255,255,0.6)"}}>
        
        <TextInput style={styles.InputBox}
        placeholder = "Enter Book Name" 
        placeholderTextColor="black"
        onChangeText = {text => this.handleSearch(text)}
        ref = {this.textinput}
        />

        <TouchableOpacity style={styles.MenuButtons}
        onPress = {() => {this.textinput.current.clear(); this.setState({datasource: this.state.temp_Data})}}>
          <Text style={{fontSize:20,fontWeight:"bold",color:"red"}}>X</Text>
        </TouchableOpacity>
      
        <TouchableOpacity style={styles.MenuButtons}
        onPress = {this.toggleSort}>
          <Text style={{fontSize:20,fontWeight:"bold",color:"green"}}>S</Text>
        </TouchableOpacity>

      </View>
    );
  } 
  //----------------------------------------------------------------------------------------------------------------------

  //This method will run after all the components get rendered on the screen
  //Includes Fetching Data from API
  componentDidMount(){

    const url="http://www.json-generator.com/api/json/get/cejoBvsZCG?indent=2";
    fetch(url)
    .then((response) => response.json())
    .then((responseJson) =>{
      this.setState({
        datasource : responseJson.Books,
        isLoading : false,
        temp_Data : [...responseJson.Books]
      })
    })
    .catch((error) => {
      console.log(error);
    })
  }

  //----------------------------------------------------------------------------------------------------------------------

  //Seperating the flatlist components, Inserting a horizontal line b/w all the items
  seperateComponent = () =>{
    return(
      <View style={{width:"100%",height:3,backgroundColor:"grey",marginVertical:25,shadowOpacity:0.4,
      shadowOffset:{width:2,height:3}}}>
      </View>
    );
  }

  //----------------------------------------------------------------------------------------------------------------------
  
  //Function that filters the data on the basis of text we write in search box
  handleSearch = text =>{

    let newData = this.state.temp_Data.filter((item) => {
      const itemData = item.title
            ? item.title.toUpperCase()
            : ''.toUpperCase();
        const textData = text.toUpperCase();
        return itemData.indexOf(textData) > -1;
    });
    this.setState({ datasource: newData }); 
  }

  //----------------------------------------------------------------------------------------------------------------------
  
  //Function is used to sort the list items on the basis of pagecount;
  //Toggling the list items

  toggleSort = () =>
  { 
    let sortedFlag = this.state.isSorted;

    //Default list
    if(sortedFlag)
    {
      sortedFlag = !sortedFlag;
      let varData = [...this.state.temp_Data];
      this.setState({isSorted : sortedFlag,datasource : varData});
    }

    //Sorted List on basis of page count in increasing order
    else
    {
      let sortedList = [...this.state.datasource];
      sortedList = sortedList.sort((a,b)=>{
        return (a.pageCount - b.pageCount)
      });

      sortedFlag = !sortedFlag;
      this.setState({isSorted : sortedFlag,datasource : sortedList});
    }

  }

  //----------------------------------------------------------------------------------------------------------------------

  
  //Rendering the components of the Application
  render(){
    return (
      // this.state.isLoading
      // ?
      // <View style={{flex:1,justifyContent:"center",alignItems:"center"}}>
      //   <ActivityIndicator size="large" color="#330066" animating />
      // </View>
      // :
      <View style={styles.container}>
       
        <FlatList
          data={this.state.datasource}
          ListHeaderComponent={this.header}
          stickyHeaderIndices={[0]}
          renderItem={this.renderItem}
          keyExtractor={(item, index) => item._id.toString()}
          ItemSeparatorComponent = {this.seperateComponent}
        />
      </View>
    );
  }
}

//----------------------------------------------------------------------------------------------------------------------
// CSS FOR THE APPLICATION

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white'
  },

  InputBox:
  {
    height:50,
    width:250,
    borderWidth: 2,
    borderRadius:5,
    borderColor:"silver",
    textAlign:"center",
    fontWeight:"bold",
    shadowColor:"silver",
    shadowRadius:1,
    shadowOpacity:0.8,
    shadowOffset:{width:1,height:2},
    color:"black",
    fontSize:17
  },

  ViewButton:
  {
    borderWidth:2,
    borderColor:"silver",
    paddingVertical: 12,
    borderRadius:5,
    backgroundColor:"lightgreen",
    elevation:0,
    shadowOpacity:0.5,
    shadowOffset:{width:3,height:5},
  },

  TextBoxDescriptions:
  {
    marginVertical:5,
    justifyContent:"space-around",
    flexDirection:"row",
    flexWrap:"wrap",
    backgroundColor:"lightblue"
  },
  MenuButtons:{
    borderWidth:3,
    borderRadius:5,
    padding:10,
    borderColor:"silver",
    shadowOffset:{width:2,height:1},
    shadowOpacity:0.1,
    shadowColor:"black"
  },

  Description :
  {
    flex:1,
    justifyContent:'space-evenly',
    //alignContent:'center',
    width:'100%',
    textAlign:'center',
    flexWrap:'wrap',
    backgroundColor:'#f1f1f1',
    paddingVertical:12,
    shadowOffset:{width:7,height:9},
    shadowColor:'grey',
    shadowOpacity:0.3,
    marginTop:15,
    fontWeight:'bold'
  }
  });

  //----------------------------------------------------------------------------------------------------------------------
