import React from 'react'
import axios from 'axios'
import {List} from 'semantic-ui-react'

export default class ListCompanies extends React.Component
{
    state=
    {
        companies:[]
    }
    componentDidMount()
    {
        axios.get("https://localhost:5001/WeatherForecast")
        .then(res=>{
            const companies=res.data;
            this.setState({companies});
        });
    }
    render()
    {
        return (
            <List>
                {this.state.companies.map(company=> <List.Item>{company.summary}</List.Item>)} 
            </List>
        )
    }
}
