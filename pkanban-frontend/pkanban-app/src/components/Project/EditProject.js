import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { getProject, updateProject } from "../../actions/projectActions";
import classnames from "classnames";

class EditProject extends Component {
  constructor() {
    super();

    this.state = {
      id: "",
      projectName: "",
      projectIdentifier: "",
      description: "",
      startDate: "",
      endDate: "",
      errors: {},
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  //lifecycle hooks
  // componentWillReceiveProps(nextProps){
  //   console.log(nextProps);
  //   if(nextProps.errors){
  //     this.setState({errors: nextProps.errors});
  //   }
  // }
  componentWillReceiveProps(nextProps) {
    const {
      id,
      projectName,
      projectIdentifier,
      description,
      startDate,
      endDate,
    } = nextProps.project;

    const errors = nextProps.errors ? nextProps.errors : {};

    this.setState({
      id,
      projectName,
      projectIdentifier,
      description,
      startDate,
      endDate,
      errors,
    });
  }

  // static getDerivedStateFromProps(nextProps, prevState) {
  //   if (nextProps.errors !== prevState.errors) {
  //     return { errors: nextProps.errors };
  //   } else return null;
  // }

  // componentDidUpdate(prevProps, prevState) {
  //   if (prevProps.errors !== this.state.errors) {
  //     this.state.errors = prevProps.errors;
  //   }
  // }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getProject(id, this.props.history);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    const newProject = {
      id: this.state.id,
      projectName: this.state.projectName,
      projectIdentifier: this.state.projectIdentifier,
      description: this.state.description,
      startDate: this.state.startDate
        ? this.state.startDate.substring(0,10) + " 00:00:00"
        : null,
      endDate: this.state.endDate ? this.state.endDate.substring(0,10) + " 00:00:00" : null,
      errors: {}
    };
    console.log(newProject);

    this.props.updateProject(newProject, this.props.history);
  }

  render() {
    const { errors } = this.state;

    return (
      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Update Project Form</h5>
              <hr />
              <form onSubmit={this.onSubmit}>
                <div className="form-group">
                  <input
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.projectName,
                    })}
                    placeholder="Project Name"
                    type="text"
                    name="projectName"
                    value={this.state.projectName}
                    onChange={this.onChange}
                  />
                  {errors.projectName && (
                    <div className="invalid-feedback">{errors.projectName}</div>
                  )}
                </div>

                <div className="form-group">
                  <input
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.projectIdentifier,
                    })}
                    placeholder="Unique Project ID"
                    type="text"
                    name="projectIdentifier"
                    value={this.state.projectIdentifier}
                    onChange={this.onChange}
                    disabled
                  />
                  {errors.projectIdentifier && (
                    <div className="invalid-feedback">
                      {errors.projectIdentifier}
                    </div>
                  )}
                </div>

                <div className="form-group">
                  <textarea
                    className={classnames("form-control form-control-lg", {
                      "is-invalid": errors.description,
                    })}
                    placeholder="Project Description"
                    name="description"
                    value={this.state.description}
                    onChange={this.onChange}
                  ></textarea>
                  {errors.description && (
                    <div className="invalid-feedback">{errors.description}</div>
                  )}
                </div>

                <h6>Start Date</h6>
                <div className="form-group">
                  <input
                    className="form-control form-control-lg"
                    type="date"
                    name="startDate"
                    value={
                      this.state.startDate
                      ? this.state.startDate.substring(0, 10)
                      : ""
                    }
                    onChange={this.onChange}
                  />
                </div>

                <h6>Estimated End Date</h6>
                <div className="form-group">
                  <input
                    className="form-control form-control-lg"
                    type="date"
                    name="endDate"
                    value={
                      this.state.endDate
                      ? this.state.endDate.substring(0, 10)
                      : ""
                    }
                    onChange={this.onChange}
                  />
                </div>

                <input
                  className="btn btn-primary btn-block mt-4"
                  type="submit"
                  onSubmit={this.onSubmit}
                />
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

EditProject.propTypes = {
  getProject: PropTypes.func.isRequired,
  project: PropTypes.object.isRequired,
  updateProject: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  project: state.project.project,
  errors: state.errors,
});

export default connect(mapStateToProps, { getProject, updateProject })(
  EditProject
);
